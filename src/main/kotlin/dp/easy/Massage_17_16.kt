package dp.easy

object Massage_17_16 {
    fun massage(nums: IntArray): Int {
        return when (nums.size) {
            0 -> 0
            1 -> nums[0]
            2 -> maxOf(nums[0], nums[1])
            else -> {
                val dp = IntArray(nums.size)
                dp[0] = nums[0]
                dp[1] = maxOf(nums[0], nums[1])
                for (i in 2 until nums.size) {
                    dp[i] = maxOf(dp[i-1],dp[i-2]+nums[i])
                }
                return dp[nums.size - 1]
            }
        }
    }
}