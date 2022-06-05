package middle

object CoinChange_322 {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val dp = IntArray(amount + 1) { -1 }
        dp[0] = 0

        for (i in 1..amount) {
            for (coin in coins) {
                if (coin <= i && dp[i-coin]>=0) {
                    dp[i] = if (dp[i] < 0) dp[i - coin] + 1 else minOf(dp[i], dp[i - coin] + 1)
                }
            }
        }

        return  dp[amount]
    }
}

fun main() {
    val result = CoinChange_322.coinChange(intArrayOf(2), 3)
    println(result)
}