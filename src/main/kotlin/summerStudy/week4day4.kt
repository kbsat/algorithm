import kotlin.math.abs

fun `도영이가 만든 맛있는 음식`() = with(System.`in`.bufferedReader()) {
    val num = readLine().toInt()
    val list = mutableListOf<IntArray>()
    val answer = mutableListOf<List<IntArray>>()

    var min = 9999999

    // 재료 저장
    for (i in 0 until num) {
        val (s, b) = readLine().split(" ").map { it.toInt() }
        list.add(intArrayOf(s, b))
    }

    for (i in 1..num) {
        combination(answer, list, Array(list.size) { false }, 0, i)
        for (j in answer) {
            var mult = 1
            var add = 0

            for (k in j.indices) {
                mult *= j[k][0]
                add += j[k][1]
            }
            if (abs(mult - add) < min) {
                min = abs(mult - add)
            }
        }
    }
    println(min)
}

fun <T> combination(answer: MutableList<List<T>>, el: List<T>, ck: Array<Boolean>, start: Int, target: Int) {
    if (target == 0) {
        answer.addAll(listOf(el.filterIndexed { index, t -> ck[index] }))
    } else {
        for (i in start until el.size) {
            ck[i] = true
            combination(answer, el, ck, i + 1, target - 1)
            ck[i] = false
        }
    }
}
