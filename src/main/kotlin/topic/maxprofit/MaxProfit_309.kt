package topic.maxprofit

object MaxProfit_309 {
    fun maxProfit(prices: IntArray): Int {
        val len = prices.size
        if (len < 2) return 0
        val dpHas = IntArray(len)
        val dpWithout = IntArray(len)

        dpHas[0] = -prices[0]
        dpWithout[0] = 0
        for (i in 1 until len) {
            val price = prices[i]

            val lastSell = if (i > 1) dpWithout[i - 2] else 0
            dpHas[i] = maxOf(lastSell - price, dpHas[i - 1])
            dpWithout[i] = maxOf(dpWithout[i - 1], dpHas[i - 1] + price)

        }
        return maxOf(dpHas[len - 1], dpWithout[len - 1])
    }
}

fun main() {
    val result = MaxProfit_309.maxProfit(intArrayOf(1,2,3,0,2))
    println(result)
}