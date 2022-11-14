package summerStudy

fun `후보 추천하기`() = with(System.`in`.bufferedReader()) {
    val photoNum = readLine().toInt()
    val suggestions = readLine().split(" ").map { it.toInt() }

    val photoList = mutableListOf<Int>()
    val voteArr = IntArray(101)
    val ageArr = IntArray(101)

    for (suggestion in suggestions) {
        for (photo in photoList) {
            ageArr[photo] += 1
        }

        if (photoList.size < photoNum && !photoList.contains(suggestion)) {
            photoList.add(suggestion)
        } else if(!photoList.contains(suggestion)) { // 사진이 꽉 찼을 때
            // 추천횟수 가장 적은 사람 뽑음
            val min = photoList.minOfOrNull { voteArr[it] }
            val changeList = mutableListOf<Int>()
            for (photo in photoList) {
                if (voteArr[photo] == min) {
                    changeList.add(photo)
                }
            }
            changeList.sortByDescending { ageArr[it] }

            val out = changeList[0]
            photoList.remove(out)
            voteArr[changeList[0]] = 0
            ageArr[changeList[0]] = 0

            photoList.add(suggestion)
        }

        voteArr[suggestion] += 1

    }
    println(photoList.sorted().joinToString(" "))
}
