// https://www.acmicpc.net/problem/15649
fun `n과 m 1`() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    var answerArr = IntArray(m) { 0 }
    val isUsed = BooleanArray(n)

    fun func(depth: Int) {
        if (depth == m) {
            println(answerArr.joinToString(" "))
            return
        }

        for (i in isUsed.indices) {
            if (!isUsed[i]) { // isUsed[i] 가 false 라면
                answerArr[depth] = i + 1
                isUsed[i] = true
                func(depth + 1)
                isUsed[i] = false
            }
        }
    }

    func(0)
}

// https://www.acmicpc.net/problem/10974
fun `모든 순열`() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    var answer = IntArray(n) { 0 }
    var isUsed = BooleanArray(n) { false }

    fun func(depth: Int) {
        if (depth == n) {
            println(answer.joinToString(" "))
            return
        }

        for (i in isUsed.indices) {
            if (!isUsed[i]) {
                answer[depth] = i + 1
                isUsed[i] = true
                func(depth + 1)
                isUsed[i] = false
            }
        }
    }

    func(0)
}
