package programmers.lv1

import java.util.*


fun main() {
    print(`햄버거 만들기`().solution(intArrayOf(2, 1, 1, 2, 3, 1, 2, 3, 1)))

}

private const val MIN_BUGGER_SIZE = 4

private const val MEAL = 1
private const val VEGETABLE = 2
private const val MEAT = 3

class `햄버거 만들기` {

    fun solution(ingredient: IntArray): Int {
        var result = 0
        val stack = Stack<Int>()

        for (i in ingredient) {
            stack.push(i)

            if (stack.size >= MIN_BUGGER_SIZE &&
                stack[stack.lastIndex] == MEAL &&
                stack[stack.lastIndex - 1] == MEAT &&
                stack[stack.lastIndex - 2] == VEGETABLE &&
                stack[stack.lastIndex - 3] == MEAL
            ) {
                repeat(4) { stack.pop() }
                result += 1
            }
        }

        return result
    }
}
