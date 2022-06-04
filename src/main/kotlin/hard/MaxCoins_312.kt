package hard

object MaxCoins_312 {
    fun maxCoins(nums: IntArray): Int {
        val n = nums.size
        val values = IntArray(n + 2) { 1 }
        // 索引0 n+1为边界
        nums.indices.forEach { values[it + 1] = nums[it] }

        val dp = Array(n + 2) { IntArray(n + 2) { 0 } }

        for (i in n downTo 0) {
            for (j in i + 1 until n + 2) {
                for (k in i + 1 until j) {
                    dp[i][j] = maxOf(dp[i][j], dp[i][k] + dp[k][j] + values[i] * values[j] * values[k])
                }
            }
        }
        return dp[0][n + 1]

    }
}