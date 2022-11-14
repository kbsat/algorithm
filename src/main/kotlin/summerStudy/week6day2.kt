import java.lang.Integer.min

fun main(): Unit = with(System.`in`.bufferedReader()) {

    var requiredCheckNum = 0
    var minMoveCount = Integer.MAX_VALUE

    fun solution(name: String): Int {

        val nameArray: CharArray = name.toCharArray()
        var answer = 0
        val nameSize = nameArray.size
        val visit = BooleanArray(nameSize)

        visit[0] = true
        requiredCheckNum = nameSize - 1

        for (aChar in nameArray) {
            val front = aChar - 'A'
            val back = 'Z' - aChar + 1
            val min = min(front, back)
            if (min == 0) {
                requiredCheckNum -= 1
            }
            answer += min
        }

        fun dfs(visit: BooleanArray, start: Int, moveCount: Int, checkCount: Int) {

            if (checkCount == requiredCheckNum) {
                minMoveCount = min(moveCount, minMoveCount)
                return
            }

            var left = start
            var leftMoveCount = 0
            var right = start
            var rightMoveCount = 0

            while (leftMoveCount < visit.size) {
                left -= 1
                leftMoveCount += 1

                if (left < 0) {
                    left = visit.size - 1
                }

                if (!visit[left]) {
                    break
                }
            }


            while (rightMoveCount < visit.size) {
                right += 1
                rightMoveCount += 1

                if (right >= visit.size) {
                    right = 0
                }

                if (!visit[right]) {
                    break
                }
            }


            visit[left] = true
            dfs(visit, left, moveCount + leftMoveCount, checkCount + 1)
            visit[left] = false
            visit[right] = true
            dfs(visit, right, moveCount + rightMoveCount, checkCount + 1)
            visit[right] = false
        }

        dfs(visit, 0, 0, 0)


        return answer + minMoveCount
    }



    println(solution("JAN"))

}
