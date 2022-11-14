package summerStudy

fun main() = with(System.`in`.bufferedReader()) {
    val N = readLine().toInt()
    val nums: List<Int> = readLine().split(" ").map { it.toInt() }
    val answers = IntArray(nums.size + 1) { 0 }


    println(answers[N - 1])
}
