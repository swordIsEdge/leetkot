package dp.easy

object GetMaximumGenerated {
    fun getMaximumGenerated(n: Int): Int {
        if (n<=1)return n
        val dp = IntArray(n+1){ 0}
        dp[1] =1
        var max = 1
        for (i in 2..n) {
            if (i % 2 == 0) {
                dp[i] = dp[i/2]
            } else {
                dp[i] = dp[i/2]+dp[i/2+1]
            }
            max = maxOf(max,dp[i])
        }
        return max
    }
}