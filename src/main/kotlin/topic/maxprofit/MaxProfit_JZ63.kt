package topic.maxprofit

object MaxProfit_JZ63 {
    fun maxProfit(prices: IntArray): Int {
        if(prices.size< 2) return 0
        var max = 0
        var min = prices[0]
        for(i in 1 until prices.size){
            val today = prices[i]
            max = maxOf(max, today - min)
            min = minOf(min,today)
        }
        return max
    }
}