package summerStudy

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val list = mutableListOf<Pair<Int, Int>>()
    for (i in 0 until n) {
        val (x, y) = readLine().split(" ").map { it.toInt() }
        list.add(Pair(x, y))
    }

    val sort = list.sortedBy { it.first }

}
