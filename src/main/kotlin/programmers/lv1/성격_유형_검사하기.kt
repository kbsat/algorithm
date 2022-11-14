package programmers.lv1

class `성격 유형 검사하기` {
    fun solution(survey: Array<String>, choices: IntArray): String {
        var answer: String = ""

        val indicator = arrayOf("R", "T", "C", "F", "J", "M", "A", "N")
        val map = mutableMapOf(
            "R" to 0, "T" to 0, "C" to 0, "F" to 0,
            "J" to 0, "M" to 0, "A" to 0, "N" to 0
        )

        for ((i, aSurvey) in survey.withIndex()) {
            val surveyChar = aSurvey.toCharArray()

            var guess = choices[i] - 4
            if (guess < 0) {
                guess *= -1
                val first = surveyChar[0].toString()
                map[first] = map[first]!! + guess
            } else {
                val second = surveyChar[1].toString()
                map[second] = map[second]!! + guess
            }
        }

        for (i in 0 until map.size step 2) {
            if (map[indicator[i]]!! >= map[indicator[i + 1]]!!) {
                answer += indicator[i]
                continue
            }
            answer += indicator[i + 1]
        }

        return answer
    }
}
