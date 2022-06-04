package hard

import common.printSelf

object MaxSlidingWindow_239 {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val queue = mutableListOf<Int>()
        for (i in 0 until k - 1) {
            if (queue.isEmpty()) {
                queue.add(i)
            } else {
                while (queue.isNotEmpty() && nums[queue.last()] < nums[i]) {
                    queue.removeAt(queue.size - 1)
                }
                queue.add(i)
            }
        }
        val result = IntArray(nums.size - k + 1) { 0 }
        for (j in result.indices) {
            val i = j + k - 1
            while (queue.isNotEmpty() && i - queue.first() > k) {
                queue.removeAt(0)
            }
            if (queue.isEmpty()) {
                queue.add(i)
            } else {
                while (queue.isNotEmpty() && nums[queue.last()] < nums[i]) {
                    queue.removeAt(queue.size - 1)
                }
                queue.add(i)
            }
            result[j] = nums[queue.first()]
        }
        return result
    }
}

fun main() {
    val result = MaxSlidingWindow_239.maxSlidingWindow(intArrayOf(1,-1), 1)
    result.printSelf()
}