package jzof

object JZ14 {
    fun cutRope(n: Int): Int {
        // write code here
        if (n <= 3) {
            return n - 1
        }
        val dp = IntArray(n + 1)
        dp[1] = 1
        dp[2] = 1
        dp[3] = 2
        for (i in 4..n) {
            for (j in 1 until i) {
                dp[i] = maxOf(dp[i], maxOf(j, dp[j]) * maxOf(i - j, dp[i - j]))
            }

        }
        return dp[n]
    }
}