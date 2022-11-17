package boj

private const val WALL = "#"
private const val MAN = "J"
private const val FIRE = "F"
private const val EMPTY = "."

private val dx = intArrayOf(1, -1, 0, 0)
private val dy = intArrayOf(0, 0, 1, -1)

private lateinit var graph: Array<Array<String>>

fun main() {
    val br = System.`in`.bufferedReader()
    val (row, col) = br.readLine().split(" ").map { it.toInt() }
    lateinit var manPosition: Pair<Int, Int>
    val queue = ArrayDeque<Triple<Int, Int, Int>>()
    val visited = Array(row) { BooleanArray(col) }

    graph = Array(row) { Array(col) { "" } }

    for (i in 0 until row) {
        graph[i] = br.readLine().toCharArray().map { it.toString() }.toTypedArray()
        for (j in 0 until col) {
            when (graph[i][j]) {
                MAN -> manPosition = Pair(i, j)
                FIRE -> {
                    queue.add(Triple(i, j, 0))
                    graph[i][j] = "0"
                }
                else -> continue
            }
        }
    }

    bfsFire(queue)
    val count = bfsMan(manPosition, visited)
    val result = when (count) {
        Int.MAX_VALUE -> "IMPOSSIBLE"
        else -> count + 1
    }
    println(result)
}

private fun bfsMan(manPosition: Pair<Int, Int>, visited: Array<BooleanArray>): Int {
    val queue = ArrayDeque<Triple<Int, Int, Int>>()
    queue.add(Triple(manPosition.first, manPosition.second, 0))

    while (queue.isNotEmpty()) {
        val (nowX, nowY, cost) = queue.removeFirst()

        for (i in dx.indices) {
            val nx = nowX + dx[i]
            val ny = nowY + dy[i]

            if (nx < 0 || nx >= graph.size || ny < 0 || ny >= graph[0].size) {
                return cost
            }

            if (graph[nx][ny] == WALL || graph[nx][ny] == MAN || visited[nx][ny]) {
                continue
            }

            if (graph[nx][ny] == EMPTY || graph[nx][ny].toInt() > cost + 1) {
                visited[nx][ny] = true
                queue.add(Triple(nx, ny, cost + 1))
            }
        }
    }
    return Int.MAX_VALUE
}

private fun bfsFire(queue: ArrayDeque<Triple<Int, Int, Int>>) {
    while (queue.isNotEmpty()) {
        val (nowX, nowY, count) = queue.removeFirst()
        for (i in dx.indices) {
            val nx = nowX + dx[i]
            val ny = nowY + dy[i]

            when {
                nx < 0 || nx >= graph.size || ny < 0 || ny >= graph[0].size -> continue
                graph[nx][ny] == EMPTY -> {
                    graph[nx][ny] = (count + 1).toString()
                    queue.add(Triple(nx, ny, count + 1))
                }

                else -> continue
            }
        }
    }
}
