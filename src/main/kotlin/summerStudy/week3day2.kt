fun `체육복`() = with(System.`in`.bufferedReader()) {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        var answer = 0
        val reserveList = reserve.toMutableList()
        val lostList = lost.toMutableList()
        lostList.sort()

        answer = n - lost.size // 체육복 가져온 사람

        for (i in lost.indices) {
            if (reserveList.contains(lost[i])) {
                answer += 1
                reserveList.remove(lost[i])
                lostList.remove(lost[i])
            }
        }

        for (i in lostList.indices) {
            if (reserveList.contains(lostList[i] - 1)) {
                answer += 1
                reserveList.remove(lostList[i] - 1)
            } else if (reserveList.contains(lostList[i] + 1)) {
                answer += 1
                reserveList.remove(lostList[i] + 1)
            }
        }

        return answer
    }

    println(solution(5, intArrayOf(1, 2, 3), intArrayOf(1, 3)))
}


fun `큰수만들기`() = with(System.`in`.bufferedReader()) {
    fun solution(number: String, k: Int): String {
        var answer = ""
        val numList = number.toList()
        val numMutableList = numList.toMutableList()
        var max = 0

        for (i in 0 until k) {
            for (j in 0 until number.length) {
                numMutableList.removeAt(j)
                val temp = numList.joinToString(separator = "").toInt()
                if (max < temp) {
                    max = temp
                }
            }
        }


        return answer
    }

    println(solution("1924", 2))
}
