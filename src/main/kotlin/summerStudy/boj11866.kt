import java.util.*

// 요세푸스 문제 0
fun `요세푸스 문제0`() = with(System.`in`.bufferedReader()) {
    var (n: Int, k: Int) = readLine().split(" ").map { it.toInt() }

    var count: Int = 1
    val queue: Queue<Int> = LinkedList()
    val answer: MutableList<Int> = mutableListOf()

    for (i in 1..n) {
        queue.add(i)
    }

    while (queue.isNotEmpty()) {
        if (count == k) {
            answer.add(queue.poll())
            count = 1
            continue
        }
        count += 1
        queue.add(queue.poll())
    }

    println(answer.joinToString(prefix = "<", postfix = ">"))
}
