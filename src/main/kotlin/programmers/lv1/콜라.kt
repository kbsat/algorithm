package programmers.lv1

fun main() {
    print(콜라().solution(2, 1, 20))
    print(콜라().solution(3, 1, 20))
}

class `콜라` {

    fun solution(a: Int, b: Int, n: Int): Int {
        // 빈병 a 개 -> 새병 b 개
        // 가지고 있는 빈병 수 n 개
        var answer = 0
        var emptyBottleNum = n

        while (emptyBottleNum >= a) {
            val newCoke = (emptyBottleNum / a) * b
            val remain = emptyBottleNum % a

            answer += newCoke
            emptyBottleNum = newCoke + remain
        }
        return answer
    }
}
