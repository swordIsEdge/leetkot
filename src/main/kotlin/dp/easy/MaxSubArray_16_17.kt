package dp.easy

object MaxSubArray_16_17 {
    fun maxSubArray(nums: IntArray): Int {
        if (nums.size == 1) {
            return nums[0]
        }
        var mV = Int.MIN_VALUE
        var tmp = 0
        for (num in nums) {
            tmp = maxOf(0, tmp)
            tmp+=num
            mV= maxOf(mV,tmp)
        }
        return mV
    }
}