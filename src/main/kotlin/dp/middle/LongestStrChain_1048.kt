package dp.middle

import common.printSelf

object LongestStrChain_1048 {
    fun longestStrChain(words: Array<String>): Int {
        words.sortBy { it.length }
        val len = words.size
        val dp = IntArray(len) { 1 }
        var result = 1
        for (i in 1 until len) {
            val tmp = words[i]
            for (j in 0 until i) {
                if (isNext(words[j], tmp)) {
                    dp[i] = maxOf(dp[i], 1 + dp[j])
                }
            }
            result = maxOf(result, dp[i])
        }
        return result
    }

    fun isNext(sa: String, sb: String): Boolean {
        val lena = sa.length
        val lenb = sb.length
        if (lena + 1 != lenb) {
            return false
        }
        val dp = Array(lena) { BooleanArray(2) }
        for (i in 0 until lena) {
            val ca = sa[i]
            val cb = sb[i]
            val cbn = sb[i + 1]
            if (i == 0) {
                if (ca == cb) {
                    dp[0][0] = true
                    dp[0][1] = true
                } else if (ca == cbn) {
                    dp[0][1] = true
                } else {
                    return false
                }
            } else {
                if (ca == cb) {
                    dp[i][0] = dp[i - 1][0]
                    dp[i][1] = true
                }
                if (ca == cbn) {
                    dp[i][1] = dp[i - 1][1] || dp[i-1][0]
                }
            }
        }
        return dp[lena - 1][1]
    }
}

fun main1() {
    val sa = arrayOf("a", "b", "ab", "bac")
    val result = LongestStrChain_1048.longestStrChain(sa)
    result.printSelf()

}
fun main() {
    while (true) {
        val sa = readln()
        val sb = readln()
        LongestStrChain_1048.isNext(sa, sb).printSelf()
    }

}



































