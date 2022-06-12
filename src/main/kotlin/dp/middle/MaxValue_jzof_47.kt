package dp.middle

object MaxValue_jzof_47 {
    fun maxValue(grid: Array<IntArray>): Int {
        val row = grid.size
        if (row == 0) return 0
        val col = grid[0].size

        val dp = Array(row) { IntArray(col) }
        dp[0][0] = grid[0][0]
        for (i in 1 until col) {
            dp[0][i] = dp[0][i - 1] + grid[0][i]
        }
        for (i in 1 until row) {
            dp[i][0] = dp[i - 1][0] + grid[i][0]
        }
        for (i in 1 until row) {
            for (j in 1 until col) {
                dp[i][j] = grid[i][j] + maxOf(dp[i - 1][j], dp[i][j - 1])
            }
        }
        return dp[row-1][col-1]
    }
}