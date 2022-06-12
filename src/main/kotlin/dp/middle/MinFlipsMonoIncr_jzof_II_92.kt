package dp.middle

object MinFlipsMonoIncr_jzof_II_92 {
    fun minFlipsMonoIncr(s: String): Int {
        if (s.length <= 1) return 0
        val dp = Array(2) { IntArray(s.length) }
        dp[0][0] = if (s[0] == '0') 0 else 1
        dp[1][0] = if (s[0] == '1') 0 else 1
        for (i in 1 until s.length) {
            if (s[i] == '0') {
                dp[0][i] = dp[0][i - 1]
                dp[1][i] = 1 + minOf(dp[0][i - 1], dp[1][i - 1])
            } else {
                dp[0][i] = dp[0][i - 1] + 1
                dp[1][i] = minOf(dp[0][i - 1], dp[1][i - 1])
            }
        }
        return minOf(dp[0][s.length - 1], dp[1][s.length - 1])
    }
}