@file:JvmName("Week2day2Kt")

fun `숫자 문자열과 영단어`() {
    println(solution("one4seveneight"))
}

fun solution(s: String): Int {
    var answer = s
    val map: Map<String, Int> = mapOf(
        Pair("zero", 0), Pair("one", 1), Pair("two", 2),
        Pair("three", 3), Pair("four", 4), Pair("five", 5), Pair("six", 6),
        Pair("seven", 7), Pair("eight", 8), Pair("nine", 9)
    )

    for ((k, v) in map) {
        answer = answer.replace(k, v.toString())
    }
    return answer.toInt()
}

fun `수 정렬하기`() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()

    // 배열 초기화
    val nums = IntArray(10001)

    // 나타난 숫자 표시
    for (i in 0 until n) {
        nums[br.readLine().toInt()]++
    }

    for (i in 1..10000) {
        bw.write("$i\n".repeat(nums[i]))
    }

    bw.flush()
    bw.close()
    br.close()
}

fun hashing() = with(System.`in`.bufferedReader()) {
    val l: Int = readLine()!!.toInt()

    val str: String = readLine()!!
    var r = 1.0
    val m = 1234567891.0
    var answer = 0.0
    for (i in str) {
        val a = i - 'a' + 1
        answer += (a.toDouble() * r) % m
        r = r * 31 % m
    }

    println(answer.mod(m).toInt())
}
