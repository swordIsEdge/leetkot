package medium

object MaximalSquare_221 {
    fun maximalSquare(matrix: Array<CharArray>): Int {
        val h = matrix.size
        val w = matrix[0].size
        val dp = Array(h) { IntArray(w) { 0 } }
        var max = 0

        for (j in 0 until w) {
            dp[0][j] = if (matrix[0][j] == '1') 1 else 0
            max = maxOf(max,dp[0][j])
        }
        for (i in 0 until h) {
            dp[i][0] = if (matrix[i][0] == '1') 1 else 0
            max = maxOf(max,dp[i][0])

        }
        for (i in 1 until h) {
            for (j in 1 until w) {
                dp[i][j] = if (matrix[i][j]=='1') minOf(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1])+1 else 0
                max = maxOf(max,dp[i][j])
            }

        }
        return max*max
    }
}