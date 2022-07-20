package dp.middle

import common.printSelf

object Change_518 {
    fun change(amount: Int, coins: IntArray): Int {
        coins.sort()
        val dp = Array(amount + 1) { IntArray(coins.size) }
        for (i in 0..amount) {
            for ((j, coin) in coins.withIndex()) {
                if (i == 0) {
                    dp[0][j] = 1
                } else if (j == 0) {
                    if (coin <= i) {
                        dp[i][0] = dp[i - coin][0]
                    }
                } else {
                    dp[i][j] = dp[i][j-1]
                    if (coin <= i) {
                        dp[i][j]+=dp[i-coin][j]
                    }
                }
            }
        }
        return dp[amount][coins.size-1]
    }
}

fun main() {
    Change_518.change(
        5, intArrayOf(1,2,5)
    ).printSelf()
}