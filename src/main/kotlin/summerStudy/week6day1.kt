fun `풍선 터뜨리기`() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val list = readLine().split(" ").map { it.toInt() }.toMutableList()
    var balloons = list.toIntArray()
    var index = 0
    var bomb = 0

    while(true) {
        print("${index + 1} ")
        var jumpNum: Int = balloons[index]
        bomb += 1
        balloons[index] = 0

        if(bomb == n) {
            return
        }

        var count = 0
        if (jumpNum > 0) { // jumpNum이 양수
            while (count != jumpNum) {
                index = (index + 1) % n
                if (balloons[index] == 0) {
                    continue
                }
                count += 1
            }
        } else { // jumpNum이 음수
            while (count != jumpNum.unaryMinus()) {
                index = if (index == 0) {
                    n - 1
                } else {
                    index - 1
                }
                if (balloons[index] == 0) {
                    continue
                }
                count += 1
            }
        }
    }
}
    // 덱으로 풀다 메모리 초과남 ㅋ
//    val deq: ArrayDeque<Pair<Int, Int>> = ArrayDeque(n)
//
//    for (i in 1..n) {
//        deq.add(Pair(i, list[i - 1]))
//    }
//
//    while (deq.isNotEmpty()) {
//        val out = deq.removeFirst()
//        print("${out.first} ")
//        var moveNum = out.second
//
//        if (moveNum > 0) {
//            moveNum -= 1
//        }
//        for (move in 0 until moveNum.absoluteValue) {
//            if (deq.isNotEmpty() && moveNum > 0) {
//                val first = deq.removeFirst()
//                deq.addLast(first)
//            }
//            if (deq.isNotEmpty() && moveNum < 0) {
//                val last = deq.removeLast()
//                deq.addFirst(last)
//            }
//        }
//    }
