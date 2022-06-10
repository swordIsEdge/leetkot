package dp.middle

object GetKthMagicNumber_M_17_09 {
    fun getKthMagicNumber(k: Int): Int {
        if (k == 1) return 1
        val dp = IntArray(k + 1)
        dp[1] = 1
        var threeIndex = 1
        var fiveIndex = 1
        var sevenIndex = 1

        var i = 2
        while (i <= k) {
            val min = minOf(dp[threeIndex] * 3, dp[fiveIndex] * 5, dp[sevenIndex] * 7)
            if (min == dp[threeIndex] * 3) threeIndex++
            if (min == dp[fiveIndex] * 5) fiveIndex++
            if (min == dp[sevenIndex] * 7) sevenIndex++


            if (dp[i - 1] != min) {
                dp[i++] = min
            }
        }
        return dp[k]
    }
}