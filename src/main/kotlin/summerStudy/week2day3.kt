import java.util.*

fun `프린터 큐`() = with(System.`in`.bufferedReader()) {
    val testCaseNum = readLine().toInt()


    for (i in 0 until testCaseNum) {
        // setting
        val (n, m) = readLine().split(" ").map { it.toInt() }
        val weightList = readLine().split(" ").map { it.toInt() }

        val weightQueue: Queue<Int> = LinkedList(weightList)
        val queue: Queue<Int> = LinkedList()
        var count = 0

        for (j in 0 until n) {
            queue.add(j)
        }

        // 계산
        while (queue.contains(m)) {
            val poll = weightQueue.poll()
            val maxOrNull = weightQueue.maxOrNull()
            if (maxOrNull == null || poll >= maxOrNull) {
                queue.poll()
                count++
            } else {
                weightQueue.add(poll)
                queue.add(queue.poll())
            }
        }

        println(count)
    }
}

fun `스택 수열`() = with(System.`in`.bufferedReader()) {

    val num = readLine().toInt()
    val numList = (1..num).toMutableList()
    val stack = Stack<Int>()
    val output: MutableList<Int> = mutableListOf()

    for (i in 0 until num) {
        val nowNum = readLine().toInt()
        if (!stack.contains(nowNum)) {
            stack.push(nowNum)
        }
    }

}
