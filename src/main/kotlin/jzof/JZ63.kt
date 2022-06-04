package jzof

object JZ63 {
    fun maxProfit(prices: IntArray): Int {
        // write code here
        val minPrice = IntArray(prices.size)
        minPrice[0] = prices[0]
        (1 until prices.size).forEach { i: Int -> minPrice[i] = minOf(minPrice[i - 1], prices[i]) }
        var max = 0
        (1 until prices.size).forEach { i -> max = maxOf(prices[i] - minPrice[i], max) }
        return max
    }
}