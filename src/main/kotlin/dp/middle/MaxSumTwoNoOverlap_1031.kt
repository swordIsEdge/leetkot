package dp.middle

import common.printSelf

object MaxSumTwoNoOverlap_1031 {
    fun maxSumTwoNoOverlap(nums: IntArray, firstLen: Int, secondLen: Int): Int {
        val len = nums.size
        val firstSum = IntArray(len)
        var tmpSum = 0
        for (i in 0 until firstLen-1) {
            tmpSum += nums[i]
        }
        for (i in 0 .. len - firstLen) {
            tmpSum+=nums[i+firstLen-1]
            firstSum[i] = tmpSum
            tmpSum-=nums[i]
        }



        firstSum.printSelf()
        return 0
    }
}

fun main() {
    MaxSumTwoNoOverlap_1031.maxSumTwoNoOverlap(
        intArrayOf(0,6,5,2,2,5,1,9,4),
        2,
        2
    )
}