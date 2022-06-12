package dp.middle

object MinPathSum_jzof_II_99 {
    fun minPathSum(grid: Array<IntArray>): Int {
        val row = grid.size
        val col = grid[0].size
        val dp = Array(row) { IntArray(col) }
        dp[0][0] = grid[0][0]
        (1 until row).forEach { dp[it][0] = dp[it - 1][0] + grid[it][0]        }
        (1 until col).forEach { dp[0][it] = dp[0][it-1]+grid[0][it] }
        for (i in 1 until row) {
            for (j in 1 until col) {
                dp[i][j] = minOf(dp[i-1][j],dp[i][j-1])+grid[i][j]
            }
        }
        return dp[row-1][col-1]
    }
}