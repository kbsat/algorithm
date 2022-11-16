package boj

import java.util.LinkedList

private val dx = intArrayOf(1, -1, 0, 0)
private val dy = intArrayOf(0, 0, 1, -1)

fun main() {
    val br = System.`in`.bufferedReader()

    val (y, x) = br.readLine().split(" ").map { it.toInt() }

    val graph = Array(x) { IntArray(y) }
    for (i in 0 until x) {
        val rows = br.readLine().split(" ").map { it.toInt() }
        graph[i] = rows.toIntArray()
    }
    val queue = LinkedList<Triple<Int, Int, Int>>()

    // OK

    for (i in 0 until x) {
        for (j in 0 until y) {
            if (graph[i][j] == 1) {
                queue.add(Triple(i, j, 1))
            }
        }
    }
    bfs(graph, queue)

    var max = 0
    var zeroCount = 0
    for (i in 0 until x) {
        for (j in 0 until y) {
            if (graph[i][j] > max) {
                max = graph[i][j]
            }
            if (graph[i][j] == 0) {
                zeroCount += 1
            }
        }
    }
    val result = when {
        max >= 1 && zeroCount == 0 -> max - 1
        else -> -1
    }
    println(result)
}

fun bfs(graph: Array<IntArray>, queue: LinkedList<Triple<Int, Int, Int>>) {
    while (queue.isNotEmpty()) {
        val (nowX, nowY, days) = queue.removeFirst()

        for (dir in 0 until 4) {
            val nx = nowX + dx[dir]
            val ny = nowY + dy[dir]

            if (nx < 0 || nx >= graph.size || ny < 0 || ny >= graph[0].size) {
                continue
            }
            if (graph[nx][ny] != 0) {
                continue
            }

            graph[nx][ny] = days + 1
            queue.add(Triple(nx, ny, days + 1))
        }
    }
}
