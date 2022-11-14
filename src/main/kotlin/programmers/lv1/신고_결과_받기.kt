package programmers.lv1

fun main() {

    val report = arrayOf(
        "muzi frodo", "apeach frodo",
        "frodo neo", "muzi neo", "apeach muzi"
    )


}

class `신고_결과_받기` {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        val answer = IntArray(id_list.size)

        val reportIds = id_list.associateWith<String, MutableSet<String>> { mutableSetOf() }
        val reported = report.distinct()
            .map { it.split(" ") }
            .groupingBy { it.last() }
            .eachCount()

        for (r in report) {
            val split = r.split(" ")
            reportIds[split[0]]!!.add(split[1])
        }

        for ((i, id) in id_list.withIndex()) {
            for (reportedId in reportIds[id]!!) {
                val reportCount = reported[reportedId]!!
                if (reportCount >= k) {
                    answer[i] += 1
                }
            }
        }

        return answer
    }
}
