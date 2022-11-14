package programmers.lv1

class `평균 구하기` {
    fun solution(arr: IntArray): Double {
        val sum = arr.sum()
            .toDouble()
        return sum / arr.size
    }
}
