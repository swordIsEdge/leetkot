package dp.middle

object MinimumTotal_120 {
    fun minimumTotal(triangle: List<List<Int>>): Int {
        if (triangle.isEmpty()) return 0
        if (triangle.size == 1) return triangle[0].reduce { acc, cur -> minOf(acc, cur) }
        val dp = Array(triangle.size) { IntArray(it + 1) { 1 } }
        dp[triangle.size - 1] = triangle.last().toIntArray()
        for (i in triangle.size - 2 downTo 0) {
            // 此子数组的坐标为 0..i
            for (j in 0..i) {
                dp[i][j] = minOf(dp[i + 1][j], dp[i + 1][j + 1]) + triangle[i][j]
            }
        }
        return dp[0][0]
    }
}