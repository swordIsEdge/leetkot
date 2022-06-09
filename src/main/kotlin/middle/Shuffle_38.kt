package middle

import kotlin.random.Random

class Shuffle_38(nums: IntArray) {
    val nums = nums

    fun reset(): IntArray {
        return nums
    }

    fun shuffle(): IntArray {
        val len = nums.size
        if (len <= 1) {
            return nums
        }
        val list = (0 until len).toMutableList()
        val result = IntArray(len)
        for (i in 0 until len) {
            val curCount = len - i
            val r = Random.nextInt(curCount)
            val rIndex = list[r]
            list[r] = list[len-1-i]
            result[i] = nums[rIndex]
        }
        return result
    }
}