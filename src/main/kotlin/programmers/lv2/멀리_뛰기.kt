package programmers.lv2

fun main() {
    print(`멀리 뛰기`().solution(1000))

}

class `멀리 뛰기` {
    fun solution(n: Int): Long {
        val dp = LongArray(n + 1)
        dp[1] = 1L
        dp[2] = 2L

        for (i in 3..n) {
            dp[i] = dp[i - 1] + dp[i - 2]
        }
        return dp[n] % 1234567
    }
}
