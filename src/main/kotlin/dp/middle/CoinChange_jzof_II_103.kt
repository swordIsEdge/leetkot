package dp.middle

object CoinChange_jzof_II_103 {
    fun coinChange(coins: IntArray, amount: Int): Int {
        if (amount==0)return 0
        val dp = IntArray(amount + 1) { -1 }
        coins.filter { it<=amount }.forEach { dp[it] = 1 }
        val newCoin = coins.filter { it<=amount }.sorted()
        for (i in 1..amount) {
            for (c in newCoin) {
                if (c > i) {
                    break
                }else if (c == i) {
                    dp[i] = 1
                    break
                } else {
                    if (dp[i - c] > 0) {
                        if (dp[i] < 0) {
                            dp[i] = dp[i-c]+1
                        }else{
                            dp[i] = minOf(dp[i], dp[i - c] + 1)
                        }
                    }
                }
            }
        }
        return dp[amount]
    }
}