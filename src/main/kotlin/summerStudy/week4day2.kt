fun `에디터`() = with(System.`in`.bufferedReader()) {
    // L => 커서 왼쪽으로 한칸 옮긴다.
    // D => 오른쪽으로 한칸 옮긴다.
    // B => 커서 왼쪽에 있는 문자를 삭제한다.
    // P $ => $라는 문자를 커서 왼쪽에 추가한다.

    val str = readLine().toMutableList()
    val inputNum = readLine().toInt()
    var pointer = str.size

    for (i in 0 until inputNum) {
        when (val inputKey = readLine()) {
            "L" -> {
                if (pointer > 0) {
                    pointer -= 1
                }
            }
            "D" -> {
                if (pointer < str.size) {
                    pointer += 1
                }
            }
            "B" -> {
                if (pointer > 0) {
                    str.removeAt(pointer - 1)
                    pointer -= 1
                }
            }
            else -> {
                val insertCommand = inputKey.toCharArray()
                val insertWord = insertCommand[2]

                str.add(pointer, insertWord)
                pointer += 1
            }
        }
    }

    println(str.joinToString(""))
}
