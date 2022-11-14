package programmers.lv1

fun main() {
}

class `2016년` {
    fun solution(a: Int, b: Int): String {
        val days = arrayOf(0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
        val weeks = arrayOf("FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU")
        var daySum = 0
        for (i in 1 until a) {
            daySum += days[i]
        }
        daySum += b - 1

        return weeks[daySum % 7]
    }
}
