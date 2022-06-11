package dp.middle

object MinimumOperations_LCP_19 {
    fun minimumOperations(leaves: String): Int {
        val len = leaves.length
        val dp = Array(3) { IntArray(len) }
        dp[0][0] = if (leaves[0] == 'r') 0 else 1
        dp[1][0] = len+1
        dp[2][0] = len+1
        for (i in 1 until len) {
            if (leaves[i] == 'r') {
                dp[0][i] = dp[0][i - 1]
                dp[1][i] = 1 + minOf(dp[0][i - 1], dp[1][i - 1])
                dp[2][i] = minOf(dp[1][i - 1], dp[2][i - 1])
            } else {
                dp[0][i] = 1 + dp[0][i - 1]
                dp[1][i] = minOf(dp[0][i - 1], dp[1][i - 1])
                dp[2][i] = 1 + minOf(dp[1][i - 1], dp[2][i - 1])
            }
        }
        return dp[2][len - 1]
    }
}

fun main() {
    MinimumOperations_LCP_19.minimumOperations("ryr")
}