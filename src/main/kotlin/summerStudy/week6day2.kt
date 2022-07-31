import java.lang.Integer.min

fun main(): Unit = with(System.`in`.bufferedReader()) {
    fun solution(name: String): Int {
        var answer = 0
        val nameArray: CharArray = name.toCharArray()
        val nameSize = nameArray.size
        val counts = IntArray(nameSize)
        for ((idx, aChar) in nameArray.withIndex()) {
            val front = aChar - 'A'
            val back = 'Z' - aChar + 1
            counts[idx] = min(front, back)
        }

        val zeroCount = counts.count { it == 0 }
        val upAndDownCount = counts.sum()
        if (zeroCount == 0) { // answer == 0인게 없을 때
            answer = upAndDownCount + nameSize - 1
            return answer
        }

        val checkMax = nameSize - zeroCount

        var moveDirection = 1
        var checkNum = 0
        var nowIdx = 0
        var moveNum = -1

        // answer == 0 인게 있을 때
        while (checkNum != checkMax) {
            moveNum += 1
            if (counts[nowIdx] != 0) {
                counts[nowIdx] = -1
                checkNum += 1
            } else { // nowIdx 가 0일때
                // moveDirection으로 갔을 때 수가 나오는 경우
                var tempIdx = nowIdx
                while(true){

                }

                // moveDirection 반대로 갔을 때 수가 나오는 경우

                // 비교 해서 방향 틀지 결정
                // 방향 틀면 moveNum -= 2 해주자
            }

            if (nowIdx == 0 && moveDirection == -1) {
                nowIdx = nameSize - 1
                continue
            }
            nowIdx += moveDirection
        }


        return answer
    }

    solution("JEROEN")

}
