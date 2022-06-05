package middle

object CanPartition_416 {
    fun canPartition(nums: IntArray): Boolean {
        val sum = nums.sum()
        if (sum % 2 != 0) return false
        val tgt = sum shr 1
        val dp = Array(nums.size + 1) { BooleanArray(tgt + 1) { false } }
        dp[0][0] = true
        for (i in nums.indices) {
            val num = nums[i]
            dp[i + 1][0] = true
            for (j in 0..tgt) {
                dp[i + 1][j] = if (num > j) {
                    dp[i][j]
                } else {
                    dp[i][j - num] || dp[i][j]
                }
            }
        }
        return dp[nums.size][tgt]
    }
}