package dp.middle

object Rob_jzof_II_90 {
    fun rob(nums: IntArray): Int {
        val len = nums.size
        if (len == 1) return nums[0]
        if (len == 2) return maxOf(nums[0], nums[1])
        val dp = Array(2) { IntArray(len) }
        dp[0][0] = 0
        dp[0][1] = nums[1]
        dp[1][0] = nums[0]
        dp[1][1] = maxOf(nums[0], nums[1])
        for (i in 2 until len - 1) {
            dp[0][i] = maxOf(dp[0][i - 1], dp[0][i - 2] + nums[i])
            dp[1][i] = maxOf(dp[1][i - 1], dp[1][i - 2] + nums[i])
        }
        dp[0][len - 1] = maxOf(dp[0][len - 2], dp[0][len - 3] + nums[len - 1])
        dp[1][len - 1] = dp[1][len - 3]
        return maxOf(dp[0][len - 1], dp[1][len - 2])

    }
}