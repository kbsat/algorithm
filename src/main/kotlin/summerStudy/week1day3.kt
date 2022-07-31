fun `3진법 뒤집기`() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    println(solution1(n))
}

fun solution1(n: Int): Int {
    var answer: Int = 0
    var temp = n
    var pow = 1
    val list: MutableList<Int> = mutableListOf()

    while (temp >= 3) {
        list.add(temp % 3)
        temp /= 3
    }

    list.add(temp)
    list.reverse()

    println(list)

    for (i in list) {
        answer += i * pow
        pow *= 3
    }

    return answer
}


fun `최소직사각형`() = with(System.`in`.bufferedReader()) {
    var sizes: Array<IntArray> = arrayOf(
        intArrayOf(60, 50),
        intArrayOf(30, 70),
        intArrayOf(60, 30),
        intArrayOf(80, 40)
    )

    println(solution2(sizes))
}

fun solution2(sizes: Array<IntArray>): Int {
    var answer: Int = 0
    var maxWidth = 0
    var maxHeight = 0

    for (size in sizes) {
        // 하나는 무조건 최대인값
        val large = maxOf(size[0], size[1])
        maxWidth = maxOf(maxWidth, size[0], size[1])

        if (large == size[0]) {
            maxHeight = maxOf(maxHeight, size[1])
        } else if (large == size[1]) {
            maxHeight = maxOf(maxHeight, size[0])
        }
    }

    answer = maxWidth * maxHeight

    return answer
}


fun `신규 아이디 추천`() = with(System.`in`.bufferedReader()) {
    println(solution3("a"))
}

fun solution3(s: String): String {
    var answer: String = ""

    // 1
    answer = s.lowercase()

    // 2
    answer = answer.replace(Regex("[^0-9a-z._-]"), "")

    // 3
    answer = answer.replace(Regex("[.]{2,}"), ".")

    // 4
    answer = answer.replace(Regex("^[.]|[.]$"), "")

    // 5
    if (answer.isEmpty()) {
        answer += "a"
    }

    // 6
    if (answer.length >= 16) {
        answer = answer.slice(0 until 15)
        answer = answer.replace(Regex("[.]$"), "")
    }

    // 7
    while (answer.length <= 2) {
        answer += answer[answer.length - 1]
    }

    return answer
}

fun `main2`() {
    println(solution4(arrayOf("sun", "bed", "car"), 1).contentToString())
}

fun solution4(strings: Array<String>, n: Int): Array<String> {
    strings.sort()
    strings.sortBy { it[n] }
    return strings
}
