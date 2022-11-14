package summerStudy

fun main() = with(System.`in`.bufferedReader()) {

    val dx = intArrayOf(1, -1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)

    val arr = Array<IntArray>(5) {
        IntArray(5) { 0 }
    }

    for (i in 0 until 5) {
        val input = readLine().split(" ").map { it.toInt() }
        for (j in 0 until 5) {
            arr[i][j] = input[j]
        }
    }

    val set = mutableSetOf<String>()

    fun dfs(depth: Int, x: Int, y: Int, str: String) {
        var _str = str
        if (x < 0 || x >= 5 || y < 0 || y >= 5) {
            return
        }
        _str += arr[x][y].toString()

        if (depth == 6) {
            set.add(_str)

            return
        }

        for (i in 0 until 4) {
            dfs(depth + 1, x + dx[i], y + dy[i], _str)
        }
    }

    for (i in 0 until 5) {
        for (j in 0 until 5) {
            dfs(1,i,j,"")
        }
    }

    println(set.size)
}
