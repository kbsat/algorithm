package boj

fun main() {
    val br = System.`in`.bufferedReader()

    val rowNum = br.readLine().toInt()
    val matrix = Array(rowNum) { CharArray(rowNum) }
    val direction = arrayOf(Pair(-1, 0), Pair(1, 0), Pair(0, -1), Pair(0, 1))

    for (i in 0 until rowNum) {
        val str = br.readLine()
        for (j in str.indices) {
            matrix[i][j] = str[j]
        }
    }

    var max = 0
    // 현재 가장 긴거 찾기
    for (i in 0 until rowNum) {
        var xCount = 1
        var yCount = 1
        var xBefore = '0'
        var yBefore = '0'
        for (j in 0 until rowNum) {
            if (matrix[i][j] == xBefore) {
                xCount += 1
            } else {
                max = renew(max, xCount)
                xBefore = matrix[i][j]
                xCount = 1
            }

            if (matrix[j][i] == yBefore) {
                yCount += 1
            } else {
                max = renew(max, yCount)
                yBefore = matrix[j][i]
                yCount = 1
            }
        }
        max = renew(max, xCount)
        max = renew(max, yCount)
    }

    // 상하좌우 봐서 같으면 안바꿈
    // 바꿀게 있으면 ->
    // 바꿨을 때 인접한 녀석이 있는지 확인 ( b a 일 때 b에서 인접한 녀석, a에서 인접한 a가 있는지 )
    for (i in 0 until rowNum) {
        for (j in 0 until rowNum) {
            // 기준 상 , 하 , 좌 , 우 체크
            for (d in direction) {
                val nx = i + d.first
                val ny = j + d.second
                if (nx < 0 || nx >= rowNum || ny < 0 || ny >= rowNum) {
                    continue
                }
                if (matrix[i][j] == matrix[nx][ny]) {
                    // 같은 녀석이면 제외
                    continue
                }

                // matrix[i][j] , matrix[nx][ny] 이제 바꿈
                // matrix[nx][ny] 와 인접한 녀석이 있는지 확인
                val tempMatrix = Array(rowNum) { CharArray(rowNum) }
                for (tempRow in 0 until rowNum) {
                    tempMatrix[tempRow] = matrix[tempRow].copyOf()
                }

                val temp = tempMatrix[nx][ny]
                tempMatrix[nx][ny] = tempMatrix[i][j]
                tempMatrix[i][j] = temp
                var count = 1
                var before = '0'
                if (d.first == 0) { // 가로를 바꿈
                    // temp[0~rowNum][ny] temp[0~rowNum][j] 에서 최대값 찾기
                    for (col in listOf(ny, j)) {
                        count = 1
                        before = '0'
                        for (row in 0 until rowNum) {
                            if (tempMatrix[row][col] == before) {
                                count += 1
                            } else {
                                max = renew(max, count)
                                before = tempMatrix[row][col]
                                count = 1
                            }
                        }
                        max = renew(max, count)
                    }
                    // temp[i][0~rowNum] 에서 최대값 찾기
                    count = 1
                    before = '0'
                    for (col in 0 until rowNum) {
                        if (tempMatrix[i][col] == before) {
                            count += 1
                        } else {
                            max = renew(max, count)
                            before = tempMatrix[i][col]
                            count = 1
                        }
                    }
                    max = renew(max, count)
                }

                if (d.second == 0) { // 세로를 바꿈
                    // temp[nx][0~rowNum] , temp[i][0~rowNum] 의 최댓값
                    for (row in listOf(nx, i)) {
                        count = 1
                        before = '0'
                        for (col in 0 until rowNum) {
                            if (tempMatrix[row][col] == before) {
                                count += 1
                            } else {
                                max = renew(max, count)
                                before = tempMatrix[row][col]
                                count = 1
                            }
                        }
                        max = renew(max, count)
                    }

                    // temp[0~rowNum][j] 에서 최댓값 찾기
                    count = 1
                    before = '0'
                    for (row in 0 until rowNum) {
                        if (tempMatrix[row][j] == before) {
                            count += 1
                        } else {
                            max = renew(max, count)
                            before = tempMatrix[row][j]
                            count = 1
                        }
                    }
                    max = renew(max, count)
                }
            }
        }
    }

    print(max)
}

private fun renew(max: Int, count: Int): Int {
    var max1 = max
    if (max1 < count) {
        max1 = count
    }
    return max1
}
