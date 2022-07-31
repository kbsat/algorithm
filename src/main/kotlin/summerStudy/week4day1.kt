fun `잃어버린 괄호`() = with(System.`in`.bufferedReader()) {
    val str: String = readLine()

    val split = str.split("-")
    var sumSplit: List<String>
    var sum = 0

    sumSplit = split[0].split("+")
    sum = sumSplit.map { it.toInt() }.sum()
    if (split.size > 1) { // -가 하나라도 포함
        for (i in 1 until split.size) {
            sumSplit = split[i].split("+")
            sum -= sumSplit.map { it.toInt() }.sum()
        }
    }

    println(sum)
}

//fun basic.main() = with(System.`in`.bufferedReader()) {
//    val n = readLine().toInt()
//    val arr: Array<IntArray> = Array(n) { IntArray(n) }
//
//    for (i in 0 until n) {
//        val map = readLine().split(" ").map { it.toInt() }
//        arr[i] = map.toIntArray()
//    }
//
//    arr.sumOf { it.sum() }
//}
