val graph = Array(101) { IntArray(101) { 0 } }
val visit = IntArray(101) { 0 }

// DFS 문제
fun `바이러스`() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt() // 컴퓨터 개수
    val m = readLine().toInt() // 쌍의 개수

    for (i in 0 until m) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        graph[a][b] = 1
        graph[b][a] = 1
    }

    dfs1(1, n)
    val size = visit.filter { it == 1 }.size
    println(size - 1)
}

fun dfs1(node: Int, n: Int) {
    visit[node] = 1

    for (i in 1..n) {
        if (graph[node][i] == 1 && visit[i] == 0) {
            dfs1(i, n)
        }
    }
}

fun `이상한 술집`() = with(System.`in`.bufferedReader()) {
    // n = 막걸리 주전자 개수, k = 은상이 포함 친구 수
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val maks: MutableList<Long> = mutableListOf()

    for (i in 0 until n) {
        val mak = readLine().toLong()
        maks.add(mak)
    }


}
