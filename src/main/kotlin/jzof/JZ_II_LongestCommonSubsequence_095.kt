package jzof

object JZ_II_LongestCommonSubsequence_095 {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val m = text1.length
        val n = text2.length
        val dp = Array(m + 1) { IntArray(n + 1) }
        for (i in 1..m) {
            val c1 = text1[i - 1]
            for (j in 1..n) {
                val c2 = text2[j - 1]
                if (c1 == c2) {
                    dp[i][j] = 1+dp[i-1][j-1]
                } else {
                    dp[i][j] = maxOf(dp[i-1][j],dp[i][j-1])

                }
            }
        }
        return dp[m][n]
    }
}