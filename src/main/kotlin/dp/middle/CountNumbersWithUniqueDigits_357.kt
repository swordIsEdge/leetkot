package dp.middle

object CountNumbersWithUniqueDigits_357 {
    fun countNumbersWithUniqueDigits(n: Int): Int {
        return when (n) {
            0 -> 1
            1 -> 10
            else -> {
                val len = minOf(n, 10)
                val dp = IntArray(len+1) { 1 }
                dp[1] = 9
                for (i in 2..len) {
                    dp[i] = dp[i-1]*(11-i)
                }
                dp.sum()
            }
        }
    }
}