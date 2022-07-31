package basic

import io.kotest.core.spec.style.FunSpec
import java.util.*

class DFS : FunSpec({

    test("DFS 인접행렬버전") {
        val INF = Int.MAX_VALUE

        val graph = arrayOf(
            intArrayOf(0, 4, 5, INF, INF),
            intArrayOf(4, 0, INF, 3, 2),
            intArrayOf(5, INF, 0, INF, INF),
            intArrayOf(INF, 3, INF, 0, INF),
            intArrayOf(INF, 2, INF, INF, 0))

        fun dfs_stack(graph: Array<IntArray>, isVisit: BooleanArray, start: Int) {
            // 스택을 이용하여 구현
            val stack: Stack<Int> = Stack()
            stack.add(start)
            print("$start ")
            isVisit[start] = true

            while (stack.isNotEmpty()) {
                val top = stack.peek()
                var haveWay = false

                for (connectedNode in graph[top].indices) {
                    if (graph[top][connectedNode] in 1 until INF && !isVisit[connectedNode]) {
                        stack.push(connectedNode)
                        isVisit[connectedNode] = true
                        haveWay = true

                        print("$connectedNode ")
                        break
                    }
                }
                if (!haveWay) {
                    stack.pop()
                }
            }
        }

        fun dfs_recursion(graph: Array<IntArray>, isVisit: BooleanArray, n: Int) {
            isVisit[n] = true
            print("$n ")

            for (connectedNode in graph[n].indices) {
                if (graph[n][connectedNode] in 1 until INF && !isVisit[connectedNode]) {
                    dfs_recursion(graph, isVisit, connectedNode)
                }
            }
        }

        var isVisit = BooleanArray(graph.size) // 방문 노드를 false로 초기화
        dfs_stack(graph, isVisit, 0)

        isVisit = BooleanArray(graph.size) // 방문 노드를 false로 초기화
        println()
        dfs_recursion(graph, isVisit, 0)
    }

    test("DFS 인접리스트 버전") {

        val graph = listOf(
            listOf(Pair(1, 4), Pair(2, 5)), // 노드 0 인접 리스트
            listOf(Pair(0, 4), Pair(3, 3), Pair(4, 2)), // 노드 1 인접 리스트
            listOf(Pair(0, 5)), // 노드 2 인접 리스트
            listOf(Pair(1, 3)), // 노드 3 인접 리스트
            listOf(Pair(2, 4))) // 노드 4 인접 리스트


        fun dfs_stack(graph: List<List<Pair<Int, Int>>>, isVisit: BooleanArray, start: Int) {
            // 스택을 이용하여 구현
            val stack: Stack<Int> = Stack()
            stack.add(start)
            print("$start ")
            isVisit[start] = true

            while (stack.isNotEmpty()) {
                val top = stack.peek()
                var haveWay = false

                for ((node, edge) in graph[top]) {
                    if (!isVisit[node]) {
                        stack.push(node)
                        isVisit[node] = true
                        haveWay = true

                        print("$node ")
                        break
                    }
                }
                if (!haveWay) {
                    stack.pop()
                }
            }
        }

        fun dfs_recursion(graph: List<List<Pair<Int, Int>>>, isVisit: BooleanArray, n: Int) {
            isVisit[n] = true
            print("$n ")

            for ((node, edge) in graph[n]) {
                if (!isVisit[node]) {
                    dfs_recursion(graph, isVisit, node)
                }
            }
        }

        var isVisit = BooleanArray(graph.size)
        println("스택 버전 DFS : ")
        dfs_stack(graph, isVisit, 0)

        isVisit = BooleanArray(graph.size)
        println()
        println("재귀 버전 DFS : ")
        dfs_stack(graph, isVisit, 0)
    }
})
