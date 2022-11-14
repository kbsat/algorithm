package programmers.lv1

class `나머지가_1이_되는_수_찾기` {
    fun solution(n: Int): Int {
        return (1..n).first { n % it == 1}
    }
}
