package programmers.lv1

class Solution {
    fun solution(number: IntArray): Int {
        var answer: Int = 0

        for (i in 0..number.lastIndex) {
            for (j in i + 1..number.lastIndex) {
                for (k in j + 1..number.lastIndex) {
                    if (number[i] + number[j] + number[k] == 0) {
                        answer += 1
                    }
                }
            }
        }
        return answer
    }
}
