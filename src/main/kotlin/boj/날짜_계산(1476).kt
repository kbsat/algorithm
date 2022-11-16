package boj

fun main() = with(System.`in`.bufferedReader()) {
    val answer = readLine().split(" ").map { it.toInt() }
    val list = mutableListOf(1, 1, 1)
    val upperBound = intArrayOf(16, 29, 20)
    var count = 1

    while (answer != list) {
        for (i in 0..list.lastIndex) {
            list[i] += 1
            if (list[i] == upperBound[i]) {
                list[i] = 1
            }
        }
        count += 1
    }

    print(count)
}

