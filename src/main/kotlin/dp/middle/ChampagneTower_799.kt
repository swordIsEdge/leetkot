package dp.middle

import common.printSelf

object ChampagneTower_799 {
    fun champagneTower(poured: Int, query_row: Int, query_glass: Int): Double {
        val row = query_row
        val dp = Array(row + 1) { DoubleArray(row + 1) }
        val diff = query_row - query_glass
        val col = query_glass
        val zero = 0.toDouble()
        for (i in 0..row) {
            val start = maxOf(0, i - diff)
            val end = minOf(i, col)
            for (j in start..end) {
                if (i == j && i == 0) {
                    dp[i][j] = poured.toDouble() 
                } else {
                    dp[i][j] = if (j == 0) if (dp[i - 1][0] > 1) (dp[i - 1][0] - 1) / 2.0 else zero
                    else if (j == i) if (dp[i - 1][i - 1] > 1) (dp[i - 1][i - 1] - 1) / 2.0 else zero
                    else {
                        (if (dp[i - 1][j] > 1) (dp[i - 1][j] - 1) / 2.0 else zero) + (if (dp[i - 1][j - 1] > 1) (dp[i - 1][j - 1] - 1) / 2.0 else zero)
                    }
                }
            }
        }
        return if (dp[query_row][query_glass] > 1) 1.toDouble() else dp[query_row][query_glass]
    }
}

fun main() {
    val p = 100000009
    val row = 33
    val col = 17
    val res = ChampagneTower_799.champagneTower(p, row, col)
    res.printSelf()
}