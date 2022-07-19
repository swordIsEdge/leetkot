package jzof

object JZ_II_UniquePaths_098 {
    fun uniquePaths(m: Int, n: Int): Int {
        val dp = Array(m) { IntArray(n) }
        (0 until m).forEach { dp[it][0] = 1 }
        (0 until n).forEach { dp[0][it] = 1 }
        for (i in 1 until m) {
            for (j in 1 until n) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
            }
        }
        return dp[m - 1][n - 1]
    }
}