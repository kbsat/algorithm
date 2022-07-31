import java.util.*

fun `위장`() {
    val solution = Solution_w2d3()
    println(
        solution.solution1(
            arrayOf(
                arrayOf("yellowhat", "headgear"),
                arrayOf("bluesunglasses", "eyewear"),
                arrayOf("green_turban", "headgear")
            )
        )
    )

}

fun `H-Index`() {
    println(
        Solution_w2d3().solution2(
            intArrayOf(10, 10, 10, 10, 10)
        )
    )
}

fun `w2d3`() {
    println(
        Solution_w2d3().solution3(
            100, 100, intArrayOf(10,10,10,10,10,10,10,10,10,10)
        )
    )
}

class Solution_w2d3 {
    fun solution1(clothes: Array<Array<String>>): Int {
        var answer: Int = 1
        val map: MutableMap<String, MutableList<String>> = mutableMapOf()

        // wear의 맵 초기화
        for (wear in clothes) {
            if (map.containsKey(wear[1])) {
                map[wear[1]]?.add(wear[0])
            } else {
                map[wear[1]] = mutableListOf(wear[0])
            }
        }
        for (value in map.values) {
            answer *= (value.size + 1)
        }

        return answer - 1
    }

    fun solution2(citations: IntArray): Int {
        var answer = 0

        val max = citations.maxOrNull()
        for (h in 0..max!!) {
            val upperSize = citations.filter { it >= h }.size
            val lowerSize = citations.size - upperSize
            if (upperSize >= h && lowerSize <= h) {
                answer = h
            }
        }
        return answer
    }

    fun solution3(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var second = 0
        var endNum = 0
        val waiting: Queue<Int> = LinkedList()
        truck_weights.forEach { waiting.add(it) }

        val crossing: Queue<Int> = LinkedList()
        var crossingCounts: MutableList<Int> = mutableListOf()

        while (endNum < truck_weights.size) {
            second++
            // 도착한 트럭 완료처리
            if (crossingCounts.isNotEmpty() && crossingCounts[0] == bridge_length) {
                crossing.poll()
                crossingCounts.removeAt(0)
                endNum += 1
            }

            // 가고있는 트럭 거리 1추가
            crossingCounts = crossingCounts.map { it + 1 } as MutableList<Int>

            // 새 트럭 추가
            if(waiting.isEmpty()){
                continue
            }

            if (crossing.size < bridge_length &&
                crossing.sum() + waiting.peek() <= weight
            ) {
                crossing.add(waiting.poll())
                crossingCounts.add(1)
            }
        }

        return second
    }
}

