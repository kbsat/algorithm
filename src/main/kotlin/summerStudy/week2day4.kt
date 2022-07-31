package summerStudy

fun `main3`() {
    println(Solution_w2d4().solution(intArrayOf(6, 10, 2)))
    println(Solution_w2d4().solution(intArrayOf(3, 30, 34, 5, 9)))
}

class Solution_w2d4 {
    fun solution(numbers: IntArray): String {
        var answer = ""

        var strings = arrayOf<String>()
        numbers.forEach {
            strings += it.toString()
        }

        strings.sortWith(Comparator { o1, o2 ->
            (o2 + o1).compareTo(o1 + o2)
        })

        if (strings[0] == "0") {
            return "0"
        } else {
            strings.forEach {
                answer += it
            }
        }

        return answer
    }
}

