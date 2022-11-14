package programmers.lv1

class `하샤드 수` {
    fun solution(x: Int): Boolean {
        val sum = x.toString()
            .toCharArray()
            .sumOf { it.digitToInt() }

        return x % sum == 0
    }
}
