package dp.middle

object MinFlipsMonoIncr_926 {
    val ZERO = '0'
    val ONE = '1'
    fun minFlipsMonoIncr(s: String): Int {
        if (s.length <= 1) return 0
        val len = s.length
        val dp = Array(2) { IntArray(len) }
        val fc = s[0]
        dp[0][0] = if (fc == ZERO) 0 else 1
        dp[1][0] = if (fc == ONE) 0 else 1
        for (i in 1 until len) {
            val c = s[i]
            if (c == ZERO) {
                dp[0][i] = dp[0][i - 1]
                dp[1][i] = minOf(dp[0][i - 1], dp[1][i - 1]) + 1
            } else {
                dp[0][i] = dp[0][i - 1] + 1
                dp[1][i] = minOf(dp[0][i - 1], dp[1][i - 1])
            }
        }


        return minOf(dp[0][len - 1], dp[1][len - 1])
    }
}