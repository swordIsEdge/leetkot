package middle

object MinPathSum_64 {
    fun minPathSum(grid: Array<IntArray>): Int {
        if (grid.isEmpty()) return 0
        val h = grid.size
        val w = grid[0].size

        val dp = Array(h) { IntArray(w) { 0 } }
        dp[0][0] = grid[0][0]
        for (i in 1 until w) {
            dp[0][i] = dp[0][i - 1] + grid[0][i]
        }
        for (i in 1 until h) {
            dp[i][0] = dp[i - 1][0] + grid[i][0]
        }
        for (i in 1 until h) {
            for (j in 1 until w) {
                dp[i][j] = grid[i][j] + minOf(dp[i - 1][j], dp[i][j - 1])
            }
        }
        return dp[h-1][w-1]
    }
}