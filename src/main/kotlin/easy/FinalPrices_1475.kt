package easy

object FinalPrices_1475 {
    fun finalPrices(prices: IntArray): IntArray {
        val len = prices.size
        val result = IntArray(len)

        for (i in len - 1 downTo 0) {

            if (i == len - 1) result[i] = prices[i]
            else {
                result[i] = prices[i]
                for (j in i + 1 until len) {
                    if (prices[j] <= prices[i]) {
                        result[i] -= prices[j]
                        break
                    }
                }
            }
        }

        return result
    }
}