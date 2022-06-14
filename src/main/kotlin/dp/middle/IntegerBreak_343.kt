package dp.middle

import common.printSelf

object IntegerBreak_343 {
    fun integerBreak(n: Int): Int {
        val dp = IntArray(n + 1)
        dp[1] = 1
        dp[2] = 1
        for (i in 3..n) {
            dp[i] = i - 1
            for (j in 1 until i) {
                dp[i] = maxOf(dp[i], j * (i - j), j * dp[i - j])
            }
        }
        dp.printSelf()
        return dp[n]
    }
}

fun main() {
    println(IntegerBreak_343.integerBreak(120))
}