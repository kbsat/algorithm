fun `ATM`() = with(System.`in`.bufferedReader()) {
    val n: Int = readLine().toInt()
    var list: List<Int> = readLine().split(" ").map { it.toInt() }
    val timeList: MutableList<Int> = mutableListOf()
    var sum = 0
    list = list.sorted()

    for (pi in list) {
        sum += pi
        timeList.add(sum)
    }
    println(timeList.sum())
}

fun `숫자 카드`() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val cards = readLine().split(" ").map { it.toInt() }
    val m = readLine().toInt()
    val findCards = readLine().split(" ").map { it.toInt() }
    val result: MutableList<Int> = mutableListOf()

    val groupBy: Map<Int, List<Int>> = cards.groupBy { it }

    for (findCard in findCards) {
        val size = groupBy[findCard]?.size ?: 0
        result.add(size)
    }

    println(result.joinToString(separator = " "))
}

fun `나무 자르기`() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ")
    var treeHeights = readLine().split(" ").map { it.toInt() }
    treeHeights = treeHeights.sorted()


}
