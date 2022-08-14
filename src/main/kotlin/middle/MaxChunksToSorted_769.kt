package middle

import common.printSelf

object MaxChunksToSorted_769 {
    fun maxChunksToSorted(arr: IntArray): Int {
        var start = 0
        var result = 0
        for ((i, num) in arr.withIndex()) {
            start = maxOf(start, num)
            if (i == start) {
                result++
                start = i + 1
            }
        }
        return result
    }
}

fun main() {
    val arr = intArrayOf(1, 0,2,3,4)
    val res = MaxChunksToSorted_769.maxChunksToSorted(arr)
    res.printSelf()
}