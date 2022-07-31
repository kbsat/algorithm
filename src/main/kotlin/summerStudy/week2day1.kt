import java.util.*

fun `단어 정렬`() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    var list: MutableList<String> = mutableListOf()
    for (i in 0 until n) {
        list.add(readLine())
    }

    list = list.distinct().sortedWith(compareBy({ it.length }, { it })) as MutableList<String>

    for (answer in list) {
        println(answer)
    }
}

fun `제로`() = with(System.`in`.bufferedReader()) {
    val k = readLine().toInt()
    val stack = Stack<Int>()

    for (i in 0 until k) {
        val n = readLine().toInt()
        if (n == 0 && stack.isNotEmpty()) {
            stack.pop()
        } else {
            stack.push(n)
        }
    }

    val list = stack.toList()
    var answer = 0
    for (i in list) {
        answer += i
    }

    println(answer)
}

fun `체스판 다시 칠하기`() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val chess = Array(n, { CharArray(m) })

    // 체스판 초기화
    for (row in 0 until n) {
        val s = readLine()
        for ((column, c) in s.withIndex()) {
            chess[row][column] = c
        }
    }

    // 체스판 확인
    var count = 0
    val answerList: MutableList<Int> = mutableListOf()
    var first: Char
    var second: Char

    for (startRow in 0..n - 8) {
        for (startColumn in 0..m - 8) {
            for (i in 1..2) {
                if (i == 1) {
                    first = 'W'
                    second = 'B'
                } else {
                    first = 'B'
                    second = 'W'
                }

                // 짝수 0 2 4 6 8
                for (row in startRow until startRow + 8) {
                    for (column in startColumn until startColumn + 8 step 2) {
                        if (chess[row][column] != first) {
                            count++
                        }
                    }
                    first = if (first == 'W') {
                        'B'
                    } else {
                        'W'
                    }
                }

                for (row in startRow until startRow + 8) {
                    for (column in startColumn + 1 until startColumn + 8 step 2) {
                        if (chess[row][column] != second) {
                            count++
                        }
                    }
                    second = if (second == 'W') {
                        'B'
                    } else {
                        'W'
                    }
                }
                answerList.add(count)
                count = 0
            }

        }
    }

    val min = answerList.minOrNull()
    println(min)
}
