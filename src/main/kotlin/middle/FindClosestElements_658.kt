package middle

import common.printSelf
import kotlin.math.abs

object FindClosestElements_658 {
    fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
        val len = arr.size
        if (len <= k) {
            return arr.asList()
        }
        if (x <= arr[0]) {
            return arr.toList().subList(0, k)
        }
        if (x >= arr[len - 1]) {
            return arr.toList().subList(len - k, len)
        }
        val baseIndex = findBaseIndex(arr, x)
        if (k == 1) {
            return listOf(arr[baseIndex])
        } else {
            var count = 1
            var left = baseIndex - 1
            var right = baseIndex + 1
            while (count < k) {
                if (left < 0) {
                    right++
                } else if (right >= len) {
                    left--
                } else {
                    val lv = arr[left]
                    val rv = arr[right]
                    if (abs(lv - x) <= abs(rv - x)) {
                        left--
                    } else {
                        right++
                    }
                }
                count++
            }
            return arr.asList().subList(left + 1, right)
        }
    }

    fun findBaseIndex(arr: IntArray, x: Int): Int {
        val hitIndex = arr.binarySearch(x)
        return if (hitIndex >= 0) {
            hitIndex
        } else {
            val insertPoint = hitIndex.inv()
            if (insertPoint > 0 && abs(x - arr[insertPoint - 1]) <= abs(x - arr[insertPoint])) {
                insertPoint - 1
            } else {
                insertPoint
            }
        }
    }

}

fun main() {
    val arr = intArrayOf(1,3)
    val k = 1
    val x = 2
    val res = FindClosestElements_658.findClosestElements(arr, k, x)
    res.printSelf()
}