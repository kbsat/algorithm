package boj

private lateinit var graph_그림: Array<IntArray>
private val dx = intArrayOf(1, -1, 0, 0)
private val dy = intArrayOf(0, 0, 1, -1)

var width = 0
var count = 0

fun main() {
    val br = System.`in`.bufferedReader()
    val (rowNum, colNum) = br.readLine().split(" ").map { it.toInt() }


    graph_그림 = Array(rowNum) { IntArray(colNum) }
    for (i in 0 until rowNum) {
        val rows = br.readLine().split(" ").map { it.toInt() }
        graph_그림[i] = rows.toIntArray()
    }

    var maxWidth = 0

    for (i in 0 until rowNum) {
        for (j in 0 until colNum) {
            width = 0
            dfs(i, j)
            if (width > 0) {
                count += 1
            }
            if (width > maxWidth) {
                maxWidth = width
            }
        }
    }

    println(count)
    println(maxWidth)
}

fun dfs(row: Int, column: Int) {
    if (graph_그림[row][column] != 1) {
        return
    }

    graph_그림[row][column] = -1
    width += 1

    for (i in dx.indices) {
        val nx = row + dx[i]
        val ny = column + dy[i]

        if (nx < 0 || nx >= graph_그림.size || ny < 0 || ny >= graph_그림[0].size) {
            continue
        }
        dfs(nx, ny)
    }
}
