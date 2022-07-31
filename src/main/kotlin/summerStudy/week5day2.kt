fun `타겟 넘버`() = with(System.`in`.bufferedReader()) {
    fun solution(numbers: IntArray, target: Int): Int {
        var answer = 0

        fun dfs(numbers: IntArray, target: Int, depth: Int, now: Int) {
            if (depth == numbers.size) {
                if (now == target) {
                    answer += 1
                }
                return
            }

            dfs(numbers, target, depth + 1, now + numbers[depth])
            dfs(numbers, target, depth + 1, now - numbers[depth])
        }
        dfs(numbers, target, 0, 0)

        return answer
    }
}
