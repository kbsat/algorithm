package programmers.lv1

class `푸드 파이트 대회` {
    fun solution(food: IntArray): String {
        var answer: String = ""
        // /2 해서 앞에서부터 개수만큼 앞에서 적음

        for (i in 1 until food.size) {
            val n = food[i] / 2
            repeat(n) { answer += i.toString() }
        }
        val reversed = answer.reversed()

        answer += "0"
        answer += reversed

        return answer
    }
}
