package dp.middle

object MinPathCost_5270 {
    fun minPathCost(grid: Array<IntArray>, moveCost: Array<IntArray>): Int {
        val row = grid.size
        val col = grid[0].size
        val dp = Array(row) { IntArray(col) }
        (0 until col).forEach { dp[0][it] = grid[0][it] }
        for (i in 1 until row) {
            for (j in 0 until col) {
                var min = Int.MAX_VALUE
                for (k in 0 until col) {
                    min = minOf(
                        min,
                        dp[i - 1][k]  //上一行的代价
                                + moveCost[grid[i - 1][k]][j]// 从上一行的k到达本行j的代价
                    )
                }
                dp[i][j] = min + grid[i][j]
            }
        }
        var result = dp[row - 1][0]
        for (i in 1 until col) {
            result = minOf(result, dp[row - 1][i])
        }
        return result
    }
}