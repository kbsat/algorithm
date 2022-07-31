fun main() = with(System.`in`.bufferedReader()) {

    while (true) {
        val list: List<Int> = readLine().split(" ").map { it.toInt() }
        val num = list[0]

        if (num == 0) {
            break
        }
        val arr = list.subList(1, list.size).sorted().toIntArray()
        val isVisit = BooleanArray(arr.size)

        fun func(depth: Int, start: Int) {
            if (depth == 6) {
                val count = isVisit.count { it }
                if (count == 6) {
                    for ((i, v) in isVisit.withIndex()) {
                        if (v) {
                            print("${arr[i]} ")
                        }
                    }
                    println()
                }
                return
            }

            for (i in start until arr.size) {
                isVisit[i] = true
                func(depth + 1, start + 1)
                isVisit[i] = false
            }
        }

        func(0, 0)
        println()
    }
}
