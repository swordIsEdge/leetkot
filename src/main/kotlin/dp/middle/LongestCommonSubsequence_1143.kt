package dp.middle

object LongestCommonSubsequence_1143 {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        val dp = Array(text1.length) { IntArray(text2.length) }
        dp[0][0] = if (text1[0] == text2[0]) 1 else 0
        (1 until text2.length).forEach { if (text1[0] == text2[it]) dp[0][it] = 1 else dp[0][it] = dp[0][it - 1] }
        for (i in 1 until text1.length) {
            dp[i][0] = if (text1[i] == text2[0]) 1 else dp[i - 1][0]
            for (j in 1 until text2.length) {
                dp[i][j] = if (text1[i] == text2[j]) {
                    minOf(dp[i - 1][j], dp[i][j - 1]) + 1
                } else {
                    maxOf(dp[i - 1][j], dp[i][j - 1])
                }

            }
        }
        return dp[text1.length - 1][text2.length - 1]
    }

}

fun main() {
    val r = LongestCommonSubsequence_1143.longestCommonSubsequence("bsbininm",
        "jmjkbkjkv")
    println(r)
}