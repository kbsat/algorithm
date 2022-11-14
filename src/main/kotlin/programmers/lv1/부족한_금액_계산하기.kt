package programmers.lv1

class `부족한 금액 계산하기` {
    fun solution(price: Int, money: Int, count: Int): Long {
        var myMoney: Long = money.toLong()

        for (n in 1..count) {
            myMoney -= price * n
        }

        return when {
            myMoney < 0 -> myMoney * - 1
            else -> 0
        }
    }
}
