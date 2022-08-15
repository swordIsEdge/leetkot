package hard

import common.printSelf

object MaxChunksToSorted_768 {
    fun maxChunksToSorted(arr: IntArray): Int {
        val len = arr.size
        val right = IntArray(len)
        for (i in arr.size - 1 downTo 0) {
            val num = arr[i]
            right[i] = if (i == len - 1) {
                num
            } else {
                minOf(num, right[i + 1])
            }
        }
        var result = 0
        var max = arr[0]
        for ((i, num) in arr.withIndex()) {
            max = maxOf(max,num)
            if (i == len - 1) {
                result++
            } else {
                if (max <= right[i + 1]) {
                    result++
                }
            }
        }
        return result

    }
}

fun main() {
//    val arr = intArrayOf(2, 1, 3, 4, 4)
    val arr = intArrayOf(4,2,2,1,1)
    val res = MaxChunksToSorted_768.maxChunksToSorted(arr)
    res.printSelf()
}