fun main() {
    // (직접 초대한 사람 수 x 10) + (내가 초대한 사람이 초대한 사람 수 * 3) + (내가 초대한 사람이 초대한 사람이 초대한 사람 수 * 1)
    class Solution {

        fun solution(invitationPairs: Array<LongArray>): LongArray {
            var point: MutableMap<Long, Int> = mutableMapOf()

            val map: MutableMap<Long, MutableList<Long>> = mutableMapOf()

            for (pair in invitationPairs) {
                map.putIfAbsent(pair[0], mutableListOf())

                map[pair[0]]?.add(pair[1])
            }

            for (member in map.keys) {
                point.put(member, bfs(map, member, 0))
            }

            var pointList = point.toList()
            val sortedBy: List<Pair<Long, Int>> = pointList.sortedByDescending { it.second }
            pointList = sortedBy
            if (sortedBy.size > 3) {
                pointList = sortedBy.subList(0, 3)
            }

            val answer = LongArray(pointList.size)
            for ((i, pair) in pointList.withIndex()) {
                answer[i] = pair.first
            }

            return answer
        }

        fun bfs(map: MutableMap<Long, MutableList<Long>>, start: Long, depth: Int): Int {
            var point = 0
            if (depth == 3 || map[start] == null) {
                return 0
            }
            var multi = 0
            when (depth) {
                0 -> multi = 10
                1 -> multi = 3
                2 -> multi = 1
            }

            val size = map[start]!!.size
            point += size * multi

            for (i in map[start]!!) {
                point += bfs(map, i, depth + 1)
            }

            return point
        }
    }
    println(Solution().solution(
        arrayOf(
            longArrayOf(1, 2),
            longArrayOf(1, 3),
            longArrayOf(3, 4),
            longArrayOf(4, 5),
            longArrayOf(4, 6),
            longArrayOf(4, 7),
        )).contentToString())

}
