package programmers.lv1

class `x만큼 간격이 있는 n개의 숫자` {
    fun solution(x: Int, n: Int): LongArray {
        val answer = LongArray(n)

        for (i in 0 until n) {
            answer[i] = (x.toLong() * (i + 1))
        }

        return answer
    }
}
