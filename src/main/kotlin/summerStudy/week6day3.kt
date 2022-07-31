fun `유기농 배추`() = with(System.`in`.bufferedReader()) {
    val testCaseNum = readLine().toInt()
    val answerArr = IntArray(testCaseNum) { 0 }

    fun dfs(arr: Array<IntArray>, x: Int, y: Int) {
        if (x < 0 || x >= arr.size || y < 0 || y >= arr[0].size) {
            return
        }

        if (arr[x][y] == 1) {
            arr[x][y] = 0
        } else {
            return
        }

        dfs(arr, x + 1, y)
        dfs(arr, x - 1, y)
        dfs(arr, x, y + 1)
        dfs(arr, x, y - 1)
    }

    for (test in 0 until testCaseNum) {
        val (m, n, k) = readLine().split(" ").map { it.toInt() }
        var count = 0

        val arr = Array(n) { IntArray(m) { 0 } }
        for (i in 0 until k) {
            val (b, a) = readLine().split(" ").map { it.toInt() }
            arr[a][b] = 1
        }

        for (i in 0 until n) {
            for (j in 0 until m) {
                if (arr[i][j] == 1) {
                    count += 1
                    dfs(arr, i, j)
                }
            }
        }
        answerArr[test] = count
    }
    for (answer in answerArr) {
        println(answer)
    }
}
