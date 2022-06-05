package dp.easy

object NumWays_offer_10 {
    fun numWays(n: Int): Int {
        if(n<=1) return 1
        val dp = IntArray(n+1){ 1}
        for (i in 2..n) {
            dp[i] = (dp[i-1]+dp[i-2])%1000000007
        }
        return dp[n]
    }
}