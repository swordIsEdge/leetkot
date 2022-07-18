package dp.middle

import common.printSelf
import kotlin.math.max

class LongestPalindromeSubseq_516 {
    fun longestPalindromeSubseq(s: String): Int {
        val len = s.length
        val dp = Array(len) { IntArray(len) { 0 } }
        s.indices.forEach { dp[it][it] = 1 }
        for (i in len - 1 downTo 0) {
            val c1 = s[i]
            for (j in i + 1 until len) {
                val c2 = s[j]
                dp[i][j] = if (c1 == c2) {
                    2 + dp[i + 1][j - 1]
                } else {
                    max(dp[i][j - 1], dp[i + 1][j])
                }
                println("$i,$j -> ${dp[i][j]}")
            }
        }
        return dp[0][len-1]


    }
}

fun main() {
    val c = "bbbab"
    val res = LongestPalindromeSubseq_516().longestPalindromeSubseq(c)
    res.printSelf()
}