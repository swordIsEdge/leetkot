package topic.maxprofit

object MaxProfit_714 {
    fun maxProfit(prices: IntArray, fee: Int): Int {
        val dp0 = IntArray(prices.size) { 0 } //手里有股票
        val dp1 = IntArray(prices.size) { 0 } //手里没有股票
        dp0[0] = -prices[0]-fee
        dp1[0] = 0
        for (i in 1 until prices.size) {
            dp0[i] = maxOf(dp0[i - 1], dp1[i - 1] - prices[i]-fee)
            dp1[i] = maxOf(dp1[i - 1], dp0[i - 1] + prices[i])
        }
        return dp1[prices.size-1]
    }
}