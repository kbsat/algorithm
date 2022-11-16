package boj

fun main() {
    val br = System.`in`.bufferedReader()

    val rowNum = br.readLine().toInt()
    val matrix = Array(rowNum) { CharArray(rowNum) }

    for (i in 0 until rowNum) {
        val str = br.readLine()
        for (j in str.indices) {
            matrix[i][j] = str[j]
        }
    }
}
