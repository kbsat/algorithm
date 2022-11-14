package codingtest.toss

import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {


}

class Solution {
    lateinit var visited: BooleanArray
    var maxCount = 0
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        visited = BooleanArray(dungeons.size)
        backTracking(dungeons, k, 0)
        return maxCount
    }

    fun backTracking(dungeons: Array<IntArray>, current: Int, count: Int) {

        if (count == dungeons.size) {
            maxCount = max(maxCount, count)
            return
        }
        for (i in dungeons.indices) {
            if (visited[i]) {
                continue
            }
            if (current < dungeons[i][0]) {
                maxCount = max(maxCount, count)
                continue
            }
            visited[i] = true
            backTracking(dungeons, current-dungeons[i][1], count+1)
            visited[i] = false
        }
    }
}
