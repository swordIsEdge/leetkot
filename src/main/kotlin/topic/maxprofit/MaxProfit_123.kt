package topic.maxprofit

object MaxProfit_123 {
    fun maxProfit(prices: IntArray): Int {
        val len = prices.size
        if (len < 2) return 0
        val dpBuy1 = IntArray(len)
        val dpSell1 = IntArray(len)
        val dpBuy2 = IntArray(len)
        val dpSell2 = IntArray(len)

        dpBuy1[0] = -prices[0]
        dpSell1[0] = 0
//        dpBuy2[0] = 0
        dpBuy2[0] = Int.MIN_VALUE
        dpSell2[0] = 0

        for (i in 1 until len) {
            val tmpPrice = prices[i]
            dpBuy1[i] = maxOf(dpBuy1[i - 1], -tmpPrice)
            dpSell1[i] = maxOf(dpSell1[i - 1], dpBuy1[i - 1] + tmpPrice)
            dpBuy2[i] = maxOf(dpBuy2[i - 1], dpSell1[i - 1] - tmpPrice)
            dpSell2[i] = maxOf(dpSell2[i - 1], dpBuy2[i - 1] + tmpPrice)
        }
        return maxOf(dpSell1[len - 1], dpSell2[len - 1])

    }
}

fun main() {
    val result = MaxProfit_123.maxProfit(intArrayOf(1, 2, 3, 4, 5))
    println(result)
}
// 一种简单的思路
internal class Solution {
    fun maxProfit(prices: IntArray): Int {
        val N = prices.size
        if (N == 1) {
            return 0
        }
        var result = 0
        var minValue = prices[0]
        val dp1 = IntArray(N)
        for (i in 1 until N) {
            dp1[i] = prices[i] - minValue
            result = result.coerceAtLeast(dp1[i])
            if (prices[i] < minValue) {
                minValue = prices[i]
            }
        }
        if (result < 1) {
            return 0
        }
        val dp2 = IntArray(N)
        var maxValue = prices[N - 1]
        for (i in N - 2 downTo 0) {
            dp2[i] = Math.max(maxValue - prices[i], dp2[i + 1])
            if (prices[i] > maxValue) {
                maxValue = prices[i]
            }
        }

        for (i in 1 until N) {
            result = Math.max(dp1[i - 1] + dp2[i], result)
        }
        return result
    }
}

internal object Solution2 {
    fun maxProfit(prices: IntArray): Int {
        var max = 0
        var minVal = prices[0]
        var maxVal = prices[prices.size - 1]
        val dp = IntArray(prices.size) //从低到高，dp[i]表示第i天以及之前的区间所获得的最大利润
        val dp2 = IntArray(prices.size) //从高到低，dp2[i]表示第i天开始直到最后一天期间所获得的最大利润
        dp[0] = -prices[0]
        for (i in 1 until prices.size) {
            dp[i] = Math.max(dp[i - 1], prices[i] - minVal)
            minVal = Math.min(prices[i], minVal)
        }
        for (i in prices.size - 2 downTo 0) {
            dp2[i] = Math.max(dp2[i + 1], maxVal - prices[i])
            maxVal = Math.max(maxVal, prices[i])
        }
        for (i in 1..prices.size - 1) {
            // System.out.println(dp[i-1]+","+dp2[i]);
            max = Math.max(dp[i - 1] + dp2[i], max)
        }
        return Math.max(dp[prices.size - 1], max)
    }
}

//fun main() {
//    val result = Solution2.maxProfit(intArrayOf(4, 1, 2, 3, 12))
//    println(result)
//}