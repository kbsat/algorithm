fun main() = with(System.`in`.bufferedReader()) {

    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        var answer: Int = -1

        fun permutation(list: MutableList<IntArray>, count: Int) {
            if (count == 0) {
                println(list)
                return
            }
            for (i in dungeons.indices) {
                if (list.contains(dungeons[i])) {
                    continue
                }
                list.add(dungeons[i])
                permutation(list, count - 1)
                list.removeAt(list.size - 1)
            }
        }
        permutation(dungeons.toMutableList(), dungeons.size)


        return answer
    }

    println("hi")

//    solution(80, arrayOf(intArrayOf(80, 20), intArrayOf(50, 40), intArrayOf(30, 10)))
}
