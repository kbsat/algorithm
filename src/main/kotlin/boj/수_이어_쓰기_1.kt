package boj

fun main() {
    val br = System.`in`.bufferedReader()
    val find = br.readLine().toInt()

    var length = 0
    var step = 1
    var nextStep = 10

    for (i in 1..find) {
        if (i == nextStep) {
            step += 1
            nextStep *= 10
        }
        length += step
    }

    print(length)
}
