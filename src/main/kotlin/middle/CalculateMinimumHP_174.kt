package middle

object CalculateMinimumHP_174 {
    fun calculateMinimumHP(dungeon: Array<IntArray>): Int {
        val row = dungeon.size
        if (row == 0) return 1
        val col = dungeon[0].size
        val dp = Array(row) { IntArray(col) { 0 } }
        dp[row - 1][col - 1] = maxOf(1 - dungeon[row - 1][col - 1], 1)
        (row - 2 downTo 0).forEach { dp[it][col - 1] = maxOf(dp[it + 1][col - 1] - dungeon[it][col - 1], 1) }
        (col - 2 downTo 0).forEach { dp[row - 1][it] = maxOf(dp[row - 1][it + 1] - dungeon[row - 1][it], 1) }
        for (i in row - 2 downTo 0) {
            for (j in col - 2 downTo 0) {
                dp[i][j] = maxOf(
                    minOf(
                        dp[i + 1][j],
                        dp[i][j + 1]
                    ) - dungeon[i][j], 1
                )
            }
        }
        return dp[0][0]
    }
}

fun main() {
    CalculateMinimumHP_174.calculateMinimumHP(arrayOf(intArrayOf(2), intArrayOf(1)))
}