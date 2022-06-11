package dp.middle

object NumberOfArithmeticSlices_413 {
    fun numberOfArithmeticSlices(nums: IntArray): Int {
        if (nums.size < 3) return 0
        val dp = IntArray(nums.size)
        for (i in 2 until nums.size) {
            val tmpGap = nums[i] - nums[i - 1]
            val lastGap = nums[i - 1] - nums[i - 2]
            dp[i] = if (tmpGap == lastGap) 1 + dp[i - 1] else 0
        }
        return dp.sum()
    }
}