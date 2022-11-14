package summerStudy

fun `실패율`() {
    w9d1_1().solution(4, intArrayOf(1, 1, 1, 1))
}

class w9d1_1 {
    fun solution(N: Int, stages: IntArray): IntArray {
        val answer = mutableListOf<Int>()
        val failPeopleNumArr = IntArray(N + 1)
        val failRate = mutableListOf<Pair<Int, Double>>()
        var remainPeopleNum = stages.size

        for (failStage in stages) {
            failPeopleNumArr[failStage - 1] += 1
        }

        for (i in 0 until N) {
            if (remainPeopleNum == 0) {
                failRate.add(Pair(i + 1, 0.0))
                continue
            }
            failRate.add(Pair(i + 1, failPeopleNumArr[i].toDouble() / remainPeopleNum))
            remainPeopleNum -= failPeopleNumArr[i]
        }

        failRate.sortByDescending { it.second }
        for (f in failRate) {
            answer.add(f.first)
        }

        return answer.toIntArray()
    }
}
