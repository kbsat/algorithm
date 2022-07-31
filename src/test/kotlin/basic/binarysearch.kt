package basic

import io.kotest.core.spec.style.FunSpec

class BinarySearch : FunSpec({

    test("이진탐색") {
        val arr = intArrayOf(10, 20, 30, 40, 50, 60, 70, 80, 90, 100)

        fun binarySearch(arr: IntArray, target: Int): Int {
            var start = 0
            var end = arr.lastIndex

            while (start <= end) { // 시작 인덱스가 끝 인덱스보다 크거나 같을 때 계속 반복
                val mid = (end + start) / 2 // 중간 인덱스을 찾아준다.
                if (arr[mid] == target) { // 중간 인덱스의 값이 target 과 같으면 끝낸다.
                    return mid
                } else if (arr[mid] > target) { // 중간 인덱스의 값이 target 값보다 크면 왼쪽 영역 선택
                    end = mid - 1
                } else { // 중간 인덱스의 값이 target 값보다 작으면 오른쪽 영역 선택
                    start = mid + 1
                }
            }
            return -1 // 찾을 수 없는 경우 -1 반환
        }

        fun binarySearch2(arr: IntArray, target: Int): Int {
            var start = 0
            var end = arr.lastIndex

            while (start <= end) { // 시작 인덱스가 끝 인덱스보다 크거나 같을 때 계속 반복
                val mid = (end + start) / 2 // 중간 인덱스을 찾아준다.
                when {
                    arr[mid] == target -> return mid // 중간 인덱스의 값이 target 과 같으면 끝낸다.
                    arr[mid] > target -> end = mid - 1 // 중간 인덱스의 값이 target 값보다 크면 왼쪽 영역 선택
                    else -> start = mid + 1 // 중간 인덱스의 값이 target 값보다 작으면 오른쪽 영역 선택
                }
            }
            return -1 // 찾을 수 없는 경우 -1 반환
        }

        println(binarySearch(arr, 30))
    }
})
