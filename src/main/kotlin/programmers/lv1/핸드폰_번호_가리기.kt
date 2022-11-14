package programmers.lv1

class `핸드폰_번호_가리기` {
    fun solution(phone_number: String): String {
        val sb = StringBuilder()
        for (i in 0..phone_number.lastIndex - 4) {
            sb.append("*")
        }
        sb.append(phone_number.takeLast(4))

        return sb.toString()
    }
}
