package programmers.lv2

import kotlin.math.max

fun main() {
    `숫자 카드 나누기`().solution(intArrayOf(14, 35, 119), intArrayOf(18,30,102))
}

class `숫자 카드 나누기` {
    fun solution(arrayA: IntArray, arrayB: IntArray): Int {
        // a 조건
        val sortedA = arrayA.sorted()
        val gcdA = gcdLoop(sortedA)
        val aFlag = canDivide(arrayB, gcdA)

        // b 조건
        val sortedB = arrayB.sorted()
        val gcdB = gcdLoop(sortedB)
        val bFlag = canDivide(arrayA, gcdB)

        return when {
            aFlag && bFlag -> 0
            else -> max(gcdA, gcdB)
        }
    }

    private fun canDivide(array: IntArray, gcd: Int): Boolean {
        var aFlag = false

        for (b in array) {
            if (b % gcd == 0) {
                aFlag = true
                break
            }
        }
        return aFlag
    }

    private fun gcdLoop(list: List<Int>): Int {
        return list.reduce { a, b -> gcd(a, b) }
    }

    private fun gcd(x: Int, y: Int): Int {
        return if (y != 0) {
            gcd(y, x % y)
        } else {
            x
        }
    }
}
