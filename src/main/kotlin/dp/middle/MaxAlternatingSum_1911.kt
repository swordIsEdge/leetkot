package dp.middle

object MaxAlternatingSum_1911 {
    fun maxAlternatingSum(nums: IntArray): Long {
        val len = nums.size
        val dp = Array(len) { LongArray(2) }
        var result = 0L
        for (i in 0 until len) {
            val num = nums[i]
            if (i == 0) {
                dp[0][0] = num.toLong()
            } else {
                dp[i][0] = maxOf(num.toLong(), dp[i - 1][0], dp[i - 1][1] + num)
                dp[i][1] = maxOf(dp[i-1][1],dp[i-1][0]-num)
            }
            result = maxOf(result,dp[i][0],dp[i][1])
        }
        return result
    }
}