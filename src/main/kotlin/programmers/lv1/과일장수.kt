package programmers.lv1

fun main() {
    과일장수().solution(4, 3, intArrayOf(4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2))
}

class `과일장수`{

    fun solution(k: Int, m: Int, score: IntArray): Int {
        // 사과 1..k 점수
        // 한 상자에 사과 m개 씩
        // 상자 안 사과 중 가장 낮은 점수가 p점 일 경우 p * m이 사과 한 상자 가격
        // k = 사과 최대 점수 m : 한 상자에 사과 개수
        var result = 0
//        var scoreList = score.sortedDescending().toList()
        var scoreList = score.sortedDescending().toList()

        while (scoreList.size >= m) {
            result += scoreList[m-1] * m
            scoreList = scoreList.subList(m, scoreList.size)
        }

        return result
    }
}
