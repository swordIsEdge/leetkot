package dp.middle

import common.printSelf
import kotlin.math.max

object MaxSumTwoNoOverlap_1031 {
    fun maxSumTwoNoOverlap(nums: IntArray, firstLen: Int, secondLen: Int): Int {
        val len = nums.size
        val firstSum = IntArray(len) { Int.MIN_VALUE }
        var tmpSum = 0
        for (i in 0 until firstLen - 1) {
            tmpSum += nums[i]
        }
        for (i in 0..len - firstLen) {
            tmpSum += nums[i + firstLen - 1]
            firstSum[i] = tmpSum
            tmpSum -= nums[i]
        }
        val leftMax = IntArray(len) { Int.MIN_VALUE }
        val rightMax = IntArray(len) { Int.MIN_VALUE }
        leftMax[0] = firstSum[0]
        for (i in 1 until len) {
            leftMax[i] = max(leftMax[i - 1], firstSum[i])
        }
        rightMax[len - 1] = firstSum[len - 1]
        for (i in len - 2 downTo 0) {
            rightMax[i] = max(rightMax[i + 1], firstSum[i])
        }
//        firstSum.printSelf()
//        leftMax.printSelf()
//        rightMax.printSelf()
        var result = Int.MIN_VALUE

        tmpSum = 0
        for (i in 0 until secondLen - 1) {
            tmpSum += nums[i]
        }
        for (i in 0..len - secondLen) {
            tmpSum += nums[i + secondLen - 1]
//            println("index $i, tmpSum $tmpSum")
            if (i >= firstLen) {
                val tmpResult = leftMax[i - firstLen] + tmpSum
                result = max(result, tmpResult)
            }
            if (i < len-firstLen-secondLen) {
                val tmpResult = tmpSum + rightMax[i + secondLen]
                result = max(result, tmpResult)
            }
            tmpSum -= nums[i]
        }
        return result
    }
}

fun main() {
    MaxSumTwoNoOverlap_1031.maxSumTwoNoOverlap(
        intArrayOf(2,1,5,6,0,9,5,0,3,8),
        4,
        3
    ).printSelf()
}