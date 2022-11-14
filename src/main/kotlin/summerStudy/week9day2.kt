package summerStudy

fun main() {
    w9d2_1().solution(arrayOf("muzi", "frodo", "apeach", "neo"),
        arrayOf("muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"), 2)
}

class w9d2_1 {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        val answer = IntArray(id_list.size)
        val reportMap = hashMapOf<String, MutableList<String>>()
        val reportedNumMap = hashMapOf<String, Int>()
        for (id in id_list) {
            reportMap[id] = mutableListOf()
            reportedNumMap[id] = 0
        }

        for (aReport in report) {
            val (reporter, reported) = aReport.split(" ")
            reportMap[reporter]?.add(reported)
            reportedNumMap[reported] = reportedNumMap[reported]!!.plus(1)
        }

        for ((idx, id) in id_list.withIndex()) {
            for (i in reportMap[id]!!) {
                if (reportedNumMap[i] == k) {
                    answer[idx] += 1
                }
            }
        }
        return answer
    }
}
