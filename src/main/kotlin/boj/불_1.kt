import java.util.*

private val dx = listOf(1, -1, 0, 0)
private val dy = listOf(0, 0, 1, -1)
private var min = Int.MAX_VALUE

fun main() {
    val br = System.`in`.bufferedReader()
    val (x, y) = br.readLine().split(" ").map { it.toInt() }
    val fireMiro = Array(x) { IntArray(y) }
    val visited = Array(x) { BooleanArray(y) }

    lateinit var jihoonPosition: Pair<Int, Int>
    val queue = LinkedList<Triple<Int, Int, Int>>()

    for (i in 0 until x) {
        val rowArray = br.readLine().toCharArray()
        for (j in 0 until y) {
            if (rowArray[j] == 'J') {
                jihoonPosition = Pair(i, j)
            }
            if (rowArray[j] == 'F') {
                queue.add(Triple(i, j, 1))
                fireMiro[i][j] = 1
            }
            if (rowArray[j] == '#') {
                fireMiro[i][j] = -1
            }
        }
    }

    bfsFire(fireMiro, queue) // 불의경로에 따라서 fireMiro 계산
    val result = bfsJihoon(fireMiro, queue, visited, jihoonPosition)

    if (result == Int.MAX_VALUE) {
        print("IMPOSSIBLE")
        return
    }

    print(result)
}

private fun bfsJihoon(
    fireMiro: Array<IntArray>,
    queue: LinkedList<Triple<Int, Int, Int>>,
    visited: Array<BooleanArray>,
    position: Pair<Int, Int>,
): Int {
    queue.add(Triple(position.first, position.second, 1))
    visited[position.first][position.second] = true

    while (queue.isNotEmpty()) {
        val (nowX, nowY, cost) = queue.removeFirst()

        for (i in 0 until 4) {
            val nx = nowX + dx[i]
            val ny = nowY + dy[i]

            if (nx < 0 || nx >= fireMiro.size || ny < 0 || ny >= fireMiro[0].size) {
                return cost + 1
            }

            // 가지 않은 곳 && 벽이 아닌곳 && 불이 내 코스트보다 느린 곳
            if (fireMiro[nx][ny] == -1 || visited[nx][ny]) {
                continue
            }
            if (fireMiro[nx][ny] > cost + 1 || fireMiro[nx][ny] == 0) {
                visited[nx][ny] = true
                queue.add(Triple(nx, ny, cost + 1))
            }
        }
    }
    return Int.MAX_VALUE
}

fun bfsFire(fireMiro: Array<IntArray>, queue: LinkedList<Triple<Int, Int, Int>>) {
    while (queue.isNotEmpty()) {
        val (nowX, nowY, cost) = queue.removeFirst()

        for (dir in 0 until 4) {
            val nx = nowX + dx[dir]
            val ny = nowY + dy[dir]

            if (nx < 0 || nx >= fireMiro.size || ny < 0 || ny >= fireMiro[0].size) {
                continue
            }

            if (fireMiro[nx][ny] != 0) {
                continue
            }

            val nextCost = cost + 1
            fireMiro[nx][ny] = nextCost
            queue.add(Triple(nx, ny, nextCost))
        }
    }
}
