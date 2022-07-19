package jzof

import common.printSelf

object JZ_II_isInterleave_096 {
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        val len1 = s1.length
        val len2 = s2.length
        val len3 = s3.length
        if (len1 + len2 != len3) {
            return false
        }
        if (len1 == 0) {
            return s2 == s3
        }
        if (len2 == 0) {
            return s1 == s3
        }
        val dp = Array(len1 + 1) { BooleanArray(len2 + 1) { false } }
        dp[0][0] = true
        for (i in 0..len1) {
            for (j in 0..len2) {
                val c1 = if (i > 0) s1[i - 1] else ' '
                val c2 = if (j > 0) s2[j - 1] else ' '
                val c3 = if (i + j - 1 in 0 until len3) s3[i + j - 1] else ' '
                if (i > 0) {
                    if (dp[i - 1][j] && c1 == c3) {
                        dp[i][j] = true
                    }

                }
                if (j > 0) {
                    if (dp[i][j - 1] && c2 == c3) {
                        dp[i][j] = true
                    }
                }
            }
        }
        return dp[len1][len2]
    }
}

fun main() {
    JZ_II_isInterleave_096.isInterleave(
        "aabcc",
        "dbbca",
        "aadbbcbcac"
    ).printSelf()
}