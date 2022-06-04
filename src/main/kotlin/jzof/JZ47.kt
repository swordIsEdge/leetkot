package jzof

object JZ47 {
    fun maxValue(grid: Array<IntArray>): Int {
        // write code here
        val h = grid.size
        val w = grid[0].size
        val dp = Array(h) { IntArray(w) }
        dp[0][0] = grid[0][0]
        (1 until w).forEach { j -> dp[0][j] = dp[0][j - 1] + grid[0][j] }
        (1 until h).forEach { i -> dp[i][0] = dp[i - 1][0] + grid[i][0] }
        for (i in 1 until h) {
            for (j in 1 until w) {
                dp[i][j] = maxOf(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]
            }
        }
        return dp[h - 1][w - 1]
    }
}