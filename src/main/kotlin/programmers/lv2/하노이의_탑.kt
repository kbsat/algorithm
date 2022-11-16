package programmers.lv2

fun main() {
    `하노이의 탑`().solution(2)
}

class `하노이의 탑` {
    fun solution(n: Int): Array<IntArray> {
        val list = mutableListOf<IntArray>()
        hanoi(list, n, 1, 2, 3)

        return list.toTypedArray()
    }

    private fun hanoi(list: MutableList<IntArray>, n: Int, from: Int, via: Int, to: Int) {
        if (n == 1) {
            list.add(intArrayOf(from, to))
            return
        }
        hanoi(list, n - 1, from, to, via)
        list.add(intArrayOf(from, to))
        hanoi(list, n - 1, via, from, to)
    }
}
