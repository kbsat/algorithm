package programmers.lv1

import kotlin.math.min

class `숫자짝꿍` {
    fun solution(X: String, Y: String): String {
        var answer: String = ""

        val xNums = IntArray(10)
        val yNums = IntArray(10)
        val pairNums = IntArray(10)

        for (x in X) {
            xNums[x.digitToInt()] += 1
        }

        for (y in Y) {
            yNums[y.digitToInt()] += 1
        }

        for (k in 0..9) {
            pairNums[k] = min(xNums[k], yNums[k])
        }

        if (pairNums.sum() == 0) {
            return "-1"
        }

        val sb = StringBuilder()
        for (num in 9 downTo 0) {
            if(sb.isEmpty() && num == 0){
                return "0"
            }
            sb.append(num.toString().repeat(pairNums[num]))
        }

        return sb.toString()
    }
}
