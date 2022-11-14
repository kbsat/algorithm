package summerStudy

fun `키로거`() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    for (i in 0 until n) {
        val d1 = ArrayDeque<Char>()
        val d2 = ArrayDeque<Char>()

        val log = readLine()

        for (ch in log) {
            when (ch) {
                '<' -> d1.removeLastOrNull()?.let { d2.addFirst(it) }
                '>' -> d2.removeFirstOrNull()?.let { d1.addLast(it) }
                '-' -> d1.removeLastOrNull()
                else -> d1.addLast(ch)
            }
        }

        println(d1.joinToString("") + d2.joinToString(""))
    }
}
