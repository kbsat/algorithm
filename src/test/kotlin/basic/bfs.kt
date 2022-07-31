package basic

import io.kotest.core.spec.style.FunSpec
import java.util.*

class BFS : FunSpec({

    test("BFS 인접행렬버전") {
        val INF = Int.MAX_VALUE
        val graph = arrayOf(
            intArrayOf(0, 4, 5, INF, INF),
            intArrayOf(4, 0, INF, 3, 2),
            intArrayOf(5, INF, 0, INF, INF),
            intArrayOf(INF, 3, INF, 0, INF),
            intArrayOf(INF, 2, INF, INF, 0))

        fun bfs(graph: Array<IntArray>, isVisit: BooleanArray, start: Int) {
            val queue: Queue<Int> = LinkedList()
            queue.offer(start)

            while (queue.isNotEmpty()) {
                val nowNode = queue.poll()
                isVisit[nowNode] = true
                print("$nowNode ")

                for (connectedNode in graph[nowNode].indices) {
                    if (graph[nowNode][connectedNode] in 1 until INF && !isVisit[connectedNode]) {
                        queue.offer(connectedNode)
                    }
                }
            }
        }

        val isVisit = BooleanArray(graph.size) // 방문 노드를 false로 초기화
//        bfs(graph, isVisit, 0)
    }

    test("BFS 인접리스트 버전") {

        val graph = listOf(
            listOf(Pair(1, 4), Pair(2, 5)), // 노드 0 인접 리스트
            listOf(Pair(0, 4), Pair(3, 3), Pair(4, 2)), // 노드 1 인접 리스트
            listOf(Pair(0, 5)), // 노드 2 인접 리스트
            listOf(Pair(1, 3)), // 노드 3 인접 리스트
            listOf(Pair(2, 4))) // 노드 4 인접 리스트


        fun bfs(graph: List<List<Pair<Int, Int>>>, isVisit: BooleanArray, start: Int) {
            val queue: Queue<Int> = LinkedList()
            queue.offer(start)

            while (queue.isNotEmpty()) {
                val nowNode = queue.poll()
                isVisit[nowNode] = true
                print("$nowNode ")

                for ((node, weight) in graph[nowNode]) {
                    if (!isVisit[node]) {
                        queue.offer(node)
                    }
                }
            }
        }

        val isVisit = BooleanArray(graph.size) // 방문 노드를 false로 초기화
        bfs(graph, isVisit, 0)
    }
})
