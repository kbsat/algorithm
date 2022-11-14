package codingtest.toss

fun main() = with(System.`in`.bufferedReader()) {
    fun solution(s: String): Int {
        if(s.isEmpty()){
            return -1
        }
        var pointer: Char = s[0]
        var count = 0
        val answers = mutableListOf<Int>()

        for (char in s) {
            if (pointer == char) {
                count += 1
            } else {
                count = 1
                pointer = char
            }

            if (count == 3) {
                answers.add("${pointer}${pointer}${pointer}".toInt())
                count = 0
            }
        }

        if (answers.isEmpty()) {
            return -1
        }
        return answers.maxOrNull()!!
    }
}
