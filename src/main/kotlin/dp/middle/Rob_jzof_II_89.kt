package dp.middle

object Rob_jzof_II_89 {
    fun rob(nums: IntArray): Int {
        val len = nums.size
        if (len == 1) return nums[0]
        if (len == 2) return maxOf(nums[0], nums[1])
        val dp = IntArray(len)
        dp[0] = nums[0]
        dp[1] = maxOf(nums[0], nums[1])
        for (i in 2 until len) {
            dp[i] = maxOf(nums[i] + dp[i - 2], dp[i - 1])
        }
        return dp[len-1]
    }
}