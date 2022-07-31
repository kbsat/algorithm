import java.util.*

// 균형잡힌 세상
fun `균형잡힌 세상`() = with(System.`in`.bufferedReader()) {
    val stack = Stack<Char>()
    var isClose: Boolean

    while (true) {
        val line = readLine()
        isClose = true
        if (line == ".") {
            return
        }

        for (c in line) {
            if (c in setOf('[', '(')) {
                stack.add(c)
            }

            if (c in setOf(')', ']')) {
                if (stack.isEmpty()) {
                    isClose = false
                    break
                }
                if (c == ')' && stack.peek() == '(') {
                    stack.pop()
                } else if (c == ']' && stack.peek() == '[') {
                    stack.pop()
                } else {
                    isClose = false
                    break
                }
            }
        }

        if (stack.isNotEmpty()) {
            isClose = false
        }

        println(
            when (isClose) {
                true -> "yes"
                else -> "no"
            }
        )
        stack.clear()
    }
}
