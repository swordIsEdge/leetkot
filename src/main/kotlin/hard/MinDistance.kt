package hard

object MinDistance {
    fun minDistance(word1: String, word2: String): Int {
        val m = word1.length
        val n = word2.length
        if (m == 0 || n == 0) {
            return m + n
        }
        val dp = Array(m + 1) { IntArray(n + 1) { Int.MAX_VALUE } }
        (0..n).forEach { dp[0][it] = it }
        (0..m).forEach { dp[it][0] = it }
        for (i in 1..m) {
            for (j in 1..n) {
                val same = word1[i - 1] == word2[j - 1]
                val left = dp[i][j - 1] + 1
                val up = dp[i - 1][j]+1
                val leftUp = dp[i - 1][j - 1] + if (same) 0 else 1
                dp[i][j] = minOf(left, up, leftUp)
            }
        }
        return dp[m][n]
    }
}