package codingtest.toss

fun main(): Unit = with(System.`in`.bufferedReader()) {
    fun solution(levels: IntArray): Int {
        val num = (levels.size * 0.25).toInt()
        val sorted = levels.sorted()

        if (num == 0) {
            return -1
        }
        return sorted[levels.size - num]
    }
}
