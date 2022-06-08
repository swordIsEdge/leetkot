package dp.middle

import common.printSelf

object IsInterleave_97 {
    fun isInterleave2(s1: String, s2: String, s3: String): Boolean {
        if (s1.isEmpty() || s2.isEmpty()) return s3 == s1 + s2
        val len1 = s1.length
        val len2 = s2.length
        val len3 = s3.length
        if (len1 + len2 != len3) return false
        val dp = Array(len1 + 1) { IntArray(len2 + 1) { -1 } }
        dp[0][0] = -1
        for (i in s2.indices) {
            dp[0][i + 1] = if (s3[dp[0][i] + 1] == s2[i]) dp[0][i] + 1 else dp[0][i]
        }
        for (j in s1.indices) {
            dp[j + 1][0] = if (s3[dp[j][0] + 1] == s1[j]) 1 + dp[j][0] else dp[j][0]
        }
        for (i in 1..s1.length) { // to s1[i-1]
            for (j in 1..s2.length) { // to s2[j-1]
                dp[i][j] = maxOf(
                    if (s1[i - 1] == s3[dp[i - 1][j] + 1]) 1 + dp[i - 1][j] else dp[i - 1][j],
                    if (s2[j - 1] == s3[dp[i][j - 1] + 1]) 1 + dp[i][j - 1] else dp[i][j - 1]
                )
            }
        }
        return dp[len1][len2] == s3.length - 1
    }
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        val n1 = s1.length
        val n2 = s2.length
        val n3 = s3.length
        if(n1+n2!=n3) return false
        val dp = BooleanArray(n2+1)
        dp[0] = true
        dp.printSelf()
        for(i in 0 .. n1){
            for(j in 0 .. n2){
                println("i = $i, j = $j")
                val p = i+j-1
                if(i>0){
                    dp[j] = dp[j]&& s1[i-1]==s3[p]
                    println("dp[$j] = dp[$j] && s1[${i-1}]==s3[$p]")
                }
                if(j>0){
                    dp[j] = dp[j] || (dp[j-1]&& s2[j-1]==s3[p])
                    println("dp[$j] = dp[$j] || (dp[${j-1}] && s2[${j-1}]==s3[$p])")
                }
            }
            dp.printSelf()
        }
        return dp[n2]
    }
}

fun main() {
    val r = IsInterleave_97.isInterleave("aabcc", "dbbca", "aadbbbaccc")
    println(r)
}