package dp.middle

object WaysToChange_M_08_11 {
    fun waysToChange(n: Int): Int {
        val dp = Array(4) { IntArray(n + 1) }
        dp[0][0] = 1
        dp[1][0] = 1
        dp[2][0] = 1
        dp[3][0] = 1
        for (i in 1..n) {
            dp[0][i] = 1
            dp[1][i] = if (i - 5 >= 0) dp[0][i - 5] % 1000000007 + dp[1][i - 5] % 1000000007 else 0
            dp[2][i] =
                if (i - 10 >= 0) dp[0][i - 10] % 1000000007 + dp[1][i - 10] % 1000000007 + dp[2][i - 10] % 1000000007 else 0
            dp[2][i] =
                if (i - 25 >= 0) dp[0][i - 25] % 1000000007 + dp[1][i - 25] % 1000000007 + dp[2][i - 25] % 1000000007 + dp[3][i - 25] % 1000000007 else 0


        }
        return dp[0][n] + dp[1][n] + dp[2][n] + dp[3][n]

    }
}

fun main() {
    WaysToChange_M_08_11.waysToChange(5)
}