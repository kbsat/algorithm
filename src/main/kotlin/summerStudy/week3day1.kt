fun `한조서열정리하고옴ㅋㅋ`() = with(System.`in`.bufferedReader()) {
    val n: Int = readLine().toInt()
    val list: List<Int> = readLine().split(" ").map { it.toInt() }
    var max: Int = 0

    for ((idx, now) in list.withIndex()) {
        var kill = 0
        for (i in (idx + 1) until (list.size)) {
            if (now >= list[i]) {
                kill += 1
            } else {
                break
            }
        }

        if (max < kill) {
            max = kill
        }
    }

    println(max)
}

// (i,j) 의 가장 위에 있는 블록을 제거하여 인벤토리에 넣는다.
// 인벤토리에서 블록 하나를 꺼내어 좌표(i,j)의 가장 위에 있는 블록 위에 놓는다.
fun `마인크래프트`() = with(System.`in`.bufferedReader()) {
    val (n, m, b) = readLine().split(" ").map { it.toInt() }

    // 블록 위에 넣을 수 있으면 넣어서 맞추는 것이 베스트다.

}
