package topic.maxprofit

object MaxProfit_121 {
    fun maxProfit(prices: IntArray): Int {
        if (prices.size < 2) {
            return 0
        }
        var result = 0
        var min = prices[0]
        for (i in 1 until prices.size) {
            result = maxOf(prices[i] - min, result)
            min = minOf(min, prices[i])
        }
        return result
    }
}