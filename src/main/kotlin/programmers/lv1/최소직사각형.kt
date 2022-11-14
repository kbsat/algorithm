package programmers.lv1

class `최소직사각형` {
    fun solution(sizes: Array<IntArray>): Int {
        // 제일 큰 숫자 하나 고름
        val sizeList = sizes.map { it.sorted() }

        val first = sizeList.maxOfOrNull { it.first() }!!
        val second = sizeList.maxOfOrNull { it.last() }!!

        return first * second
    }
}
