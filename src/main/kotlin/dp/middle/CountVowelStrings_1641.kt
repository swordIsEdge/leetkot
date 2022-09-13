package dp.middle

import common.printSelf

object CountVowelStrings_1641 {
    fun countVowelStrings(n: Int): Int {
        val dp = IntArray(5) { 1 }
        for (i in 2..n) {
            for (i in 0..4) {
                for (j in i + 1..4) {
                    dp[i] += dp[j]
                }
            }
        }
        var sum = 0
        for (i in 0 until 5) {
            sum += dp[i]
        }
        return sum

    }
}

fun main() {
    val n = 33
    val res = CountVowelStrings_1641.countVowelStrings(n)
    res.printSelf()
}