package dp.middle

object LongestStrChain_1048 {
    fun longestStrChain(words: Array<String>): Int {
        words.sortBy { it.length }
        val len = words.size
        val dp = IntArray(len) { 1 }
        for (i in 1 until len) {
            val si = words[i]
            for (j in 0 until i) {
                val sj = words[j]
                if (isNext(sj, si)) {
                    dp[i] = maxOf(dp[i], dp[j] + 1)
                }
            }
        }
        var result = 1
        dp.forEach { result = maxOf(result,it) }
        return result

    }

    fun isNext(sf: String, ss: String): Boolean {
        val lenf = sf.length
        val lens = ss.length
        if (lenf + 1 != lens) {
            return false
        }
        val dp = Array(lenf) { BooleanArray(2) }
        for (i in 0 until lenf) {
            val c1 = sf[i]
            val c2 = ss[i]
            val c22 = ss[i + 1]
            if (c1 != c2 && c1 != c22) return false
            if (c1 == c2) {
                dp[i][0] = if (i > 0) dp[i - 1][0] else true
                if (dp[i][0]) dp[i][1] = true
            }
            if (c1 == c22) {
                dp[i][1] = if (i > 0) dp[i - 1][1] else true
            }

        }
        return dp[lenf-1][1]
    }

}