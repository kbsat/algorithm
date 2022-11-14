package summerStudy

fun main() = with(System.`in`.bufferedReader()) {
    val workingDays = readLine().toInt()
    val t = IntArray(workingDays + 1) // 걸리는 시간
    val p = IntArray(workingDays + 1) // 받을 수 있는 금액
    val max = IntArray(workingDays + 1) { 0 } // 그 때 까지의 최소

    repeat(workingDays) {
        val (a, b) = readLine().split(" ").map { str -> str.toInt() }
        t[it + 1] = a
        p[it + 1] = b
    }

    for (i in 1 until workingDays) {
        val nowWorkingEndTime = i + t[i] - 1
        if (nowWorkingEndTime > workingDays) {
            max[i] = max[i - 1]
        }
        

    }
    println(max[workingDays])
}
