package boj

private val dx = intArrayOf(1, -1, 0, 0)
private val dy = intArrayOf(0, 0, 1, -1)

fun main() {
    val br = System.`in`.bufferedReader()
    val (N, M) = br.readLine().split(" ").map { it.toInt() }

    val graph = Array(N + 1) { IntArray(M + 1) }
    val costGraph = Array(N + 1) { IntArray(M + 1) { Int.MAX_VALUE } }
    val isPunched = Array(N + 1) { BooleanArray(M + 1) }

    for (i in 1..N) {
        val rowValues = br.readLine()
        for (j in 1..M) {
            graph[i][j] = rowValues[j - 1].digitToInt()
        }
    }

    bfs(graph, costGraph, isPunched, Pair(1, 1))
    if (costGraph[N][M] == Int.MAX_VALUE) {
        println("-1")
        return
    }
    println(costGraph[N][M])
}

private data class Node(
    val x: Int,
    val y: Int,
    val cost: Int,
    val remainPunch: Boolean = true,
)

private fun bfs(
    graph: Array<IntArray>,
    costGraph: Array<IntArray>,
    isPunched: Array<BooleanArray>,
    startPosition: Pair<Int, Int>,
) {
    val queue = ArrayDeque<Node>()
    queue.add(Node(startPosition.first, startPosition.second, 1))
    costGraph[startPosition.first][startPosition.second] = -1

    while (queue.isNotEmpty()) {
        val now = queue.removeFirst()

        for (i in dx.indices) {
            val nx = now.x + dx[i]
            val ny = now.y + dy[i]

            if (nx <= 0 || nx >= graph.size || ny <= 0 || ny >= graph[0].size) {
                continue
            }

            if (graph[nx][ny] == 1) { // 벽이냐?
                if (now.remainPunch) {
                    isPunched[nx][ny] = true
                    costGraph[nx][ny] = now.cost + 1
                    queue.add(Node(nx, ny, now.cost + 1, false))
                }
                continue
            }

            // 벽 아닐 때
            if (costGraph[nx][ny] <= now.cost + 1) {
                if (now.remainPunch && isPunched[nx][ny]) {
                    queue.add(Node(nx, ny, now.cost + 1, now.remainPunch))
                }
                continue
            }

            isPunched[nx][ny] = !now.remainPunch
            queue.add(Node(nx, ny, now.cost + 1, now.remainPunch))
        }
    }
}
