import java.util.*

fun `알람시계`() {
    val input = readLine()
    var (h, m) = input!!.split(" ").map { it.toInt() }

    if (m >= 45) {
        m -= 45
    } else {
        h -= 1
        m += 15
    }

    if (h == -1) {
        h = 23
    }

    println("$h $m")
}

fun `OX 퀴즈`() {
    val count = readLine()!!.toInt()

    repeat(count) {
        val input = readLine()
        var oCount = 0
        var rate = 0
        for (i in input!!) {
            if (i == 'O') {
                oCount += 1
                rate += oCount
            } else {
                oCount = 0
            }
        }
        println(rate)
    }
}

fun `상수`() {
    val input = readLine()!!.split(" ").map { it.reversed() }.map { it.toInt() }

    println(input.maxOrNull())
}

fun `단어 공부`() {
    val input = readLine()!!
    val groupBy = input.map { it.uppercaseChar() }
        .groupBy { it }

    val max = groupBy.maxOf { it.value.size }
    val count = groupBy.values.count { it.size == max }

    if (count == 1) {
        for ((k, v) in groupBy) {
            if ((v.size == max)) {
                println(k)
            }
        }
        return
    } else {
        println('?')
    }
}

fun `문자열 반복`() {
    val testCaseNum = readLine()!!.toInt()
    repeat(testCaseNum) {
        val split = readLine()!!.split(" ")
        val num = split[0].toInt()
        val code = split[1]

        for (codeChar in code) {
            repeat(num) {
                print(codeChar)
            }
        }
        println()
    }
}

fun `블랙잭`() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val sc = Scanner(System.`in`)
    val arr: MutableList<Int> = mutableListOf()
    var max = 0

    for (i in 0 until n) {
        arr.add(sc.nextInt())
    }

    for (i in 0 until n - 2) {
        for (j in i + 1 until n - 1) {
            for (k in j + 1 until n) {
                val temp = arr[i] + arr[j] + arr[k]
                if (temp in (max + 1)..m) max = temp
            }
        }
    }

    println(max)
}

fun `벌집`() {
    var n = readLine()!!.toInt()
    var dif = 0
    var max = 1
    var shell = 1

    while (max < n) {
        dif += 6
        max += dif
        shell += 1
    }
    println(shell)
}

fun `부녀회장이 될테야`() {
    val count = readLine()!!.toInt()

    repeat(count) {
        val k = readLine()!!.toInt()
        val n = readLine()!!.toInt()

        val apart = (1..n).toMutableList()

        for (i in 1..k) {
            for (j in 1 until n) {
                apart[j] += apart[j - 1]
            }
        }
        println(apart[n - 1])
    }
}
