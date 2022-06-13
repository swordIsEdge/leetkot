package dp.middle

object DicesProbability_jzof_II_60 {
    fun dicesProbability(n: Int): DoubleArray {
        val dp = IntArray(n * 6 + 1)
        val total = Math.pow(6.0, 1.0 * n)

        for (i in 1..6) {
            dp[i] = 1
        }
        for (i in 2..n) {
            for (j in i * 6 downTo i) {
                dp[j] = 0
                for (k in 1..6) {
                    if (j - k < i - 1) { //如果不加此判据，会取到n-2个骰子的数据，此时可认为是“脏数据”，会导致累加出错。从实际情况来分析，n-1个骰子的最小值就是n-1，不会比这再小
                        break
                    }
                    dp[j] = dp[j] + dp[j - k]
                }
            }
        }
        return dp.slice(n..6*n).map { it/total }.toDoubleArray()
    }
}