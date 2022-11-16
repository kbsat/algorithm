package boj

fun main() {
    val br = System.`in`.bufferedReader()

    val repeatNum = br.readLine().toInt()
    val dp = IntArray(12)
    dp[1] = 1
    dp[2] = 2
    dp[3] = 4

    for (i in 4..11) {
        if (dp[i] == 0) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]
        }
    }

    repeat(repeatNum) {
        val n = br.readLine().toInt()
        println(dp[n])
    }
}
