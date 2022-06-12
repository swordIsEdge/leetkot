package dp.middle

object NthUglyNumber_jzof_II_49 {
    fun nthUglyNumber(n: Int): Int {
        var index_2 = 0
        var index_3 = 0
        var index_5 = 0

        val dp = IntArray(n)
        dp[0] = 1
        var i = 1
        while (i < n) {
            val next = minOf(
                2 * dp[index_2],
                3 * dp[index_3],
                5 * dp[index_5]
            )
            if (next == 2 * dp[index_2]) index_2++
            if (next == 3 * dp[index_3]) index_3++
            if (next == 5 * dp[index_5]) index_5++
            if (next != dp[i - 1]) {
                dp[i++] = next
            }
        }
        return dp[n-1]
    }
}