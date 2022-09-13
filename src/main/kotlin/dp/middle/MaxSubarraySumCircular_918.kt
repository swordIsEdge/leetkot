package dp.middle

import common.printSelf

object MaxSubarraySumCircular_918 {
    fun maxSubarraySumCircular(nums: IntArray): Int {
        return maxOf(max1(nums), max2(nums))
    }

    fun max1(nums: IntArray): Int {
        val len = nums.size
        var result1 = nums[0]
        var tmp1 = nums[0]
        for (i in 1 until len) {
            val cur = nums[i]
            tmp1 = if (tmp1 > 0) {
                tmp1 + cur
            } else cur
            result1 = maxOf(result1, tmp1)
        }
        return result1
    }

    fun max2(nums: IntArray): Int {
        val len = nums.size

        val leftSum = IntArray(len)
        val leftMax = IntArray(len)
        for ((index, num) in nums.withIndex()) {
            if (index == 0) {
                leftSum[index] = num
                leftMax[index] = num
            } else {
                leftSum[index] = num + leftSum[index - 1]
                leftMax[index] = maxOf(leftMax[index - 1], leftSum[index])
            }
        }

        val rightSum = IntArray(len)
        val rightMax = IntArray(len)
        for (index in len - 1 downTo 0) {
            val num = nums[index]
            if (index == len - 1) {
                rightSum[index] = num
                rightMax[index] = num
            } else {
                rightSum[index] = num + rightSum[index + 1]
                rightMax[index] = maxOf(rightMax[index + 1], rightSum[index])
            }
        }
        var result = maxOf(rightMax[0], leftMax[len - 1])
        for (i in 0 until len - 1) {
            result = maxOf(result, leftMax[i] + rightMax[i + 1])
        }
        return result

    }
}

fun main() {
    val nums = intArrayOf(1,-2,3,-2)
    val res = MaxSubarraySumCircular_918.maxSubarraySumCircular(nums)
    res.printSelf()

}