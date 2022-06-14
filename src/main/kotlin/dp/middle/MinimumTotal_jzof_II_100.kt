package dp.middle

object MinimumTotal_jzof_II_100 {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        val len = triangle.size
        if (len == 1) return triangle[0][0]
        val dp = Array(len) { IntArray(len) }

        (0 until len).forEach { dp[len - 1][it] = triangle[len - 1][it] }

        for (i in len - 2 downTo 0) {
            for (j in 0..i ) {
                dp[i][j] = triangle[i][j] + minOf(dp[i + 1][j], dp[i + 1][j + 1])
            }
        }
        return dp[0][0]

    }
}