package programmers.lv2

class `파보나치 수` {
    fun solution(n: Int): Int {
        val fibo = IntArray(n + 1)
        fibo[0] = 0
        fibo[1] = 1

        for (i in 2..n) {
            fibo[i] = (fibo[i-2] + fibo[i-1]) % 1234567
        }

        return fibo[n]
    }
}
