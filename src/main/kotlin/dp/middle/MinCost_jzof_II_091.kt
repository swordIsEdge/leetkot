package dp.middle

object MinCost_jzof_II_091 {
    fun minCost(costs: Array<IntArray>): Int {
        val len = costs.size
        val dp = Array(len) { IntArray(3) }
        dp[0][0] = costs[0][0]
        dp[0][1] = costs[0][1]
        dp[0][2] = costs[0][2]
        for (i in 1 until len) {
            dp[i][0] = costs[i][0] + minOf(dp[i - 1][1], dp[i - 1][2])
            dp[i][1] = costs[i][1] + minOf(dp[i - 1][0], dp[i - 1][2])
            dp[i][2] = costs[i][2] + minOf(dp[i - 1][1], dp[i - 1][0])
        }
        return minOf(dp[len - 1][0], dp[len - 1][1], dp[len - 1][2])
    }
}