package programmers.lv1

// 문자열 처리, 중복된 문자열

fun main() {
    print(옹알이2().solution(arrayOf("ayaye", "uuu", "yeye", "yemawoo", "ayaayaa")))
}

class `옹알이2` {

    fun solution(babblings: Array<String>): Int {
        var answer = 0

        val words = arrayOf("aya", "ye", "woo", "ma")

        for (babbling in babblings) {
            var speak = babbling
            for (word in words) {
                speak = speak.replace(word.repeat(2), ".")
                    .replace(word, " ")
            }

            if (speak.isBlank()) {
                answer += 1
            }
        }

        return answer
    }
}
