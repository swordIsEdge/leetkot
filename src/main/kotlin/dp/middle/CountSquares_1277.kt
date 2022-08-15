package dp.middle

import common.parserArrayIntArray
import common.printSelf

object CountSquares_1277 {
    fun countSquares(matrix: Array<IntArray>): Int {
        val row = matrix.size
        val col = matrix[0].size
        val dp = Array(row) { IntArray(col) { 0 } }
        var result = 0
        for (i in 0 until row) {
            dp[i][0] = matrix[i][0]
            result += dp[i][0]
        }
        for (i in 0 until col) {
            dp[0][i] = matrix[0][i]
            result += dp[0][i]
        }
        result -= dp[0][0]

        for (i in 1 until row) {
            for (j in 1 until col) {
                if (matrix[i][j] == 0) {
                    dp[i][j] = 0
                } else {
                    dp[i][j] = 1 + minOf(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1])
                }
                result += dp[i][j]
            }
        }
        return result
    }
}

fun main() {
    val matrix = parserArrayIntArray("[\n" +
            "  [1,0,1],\n" +
            "  [1,1,0],\n" +
            "  [1,1,0]\n" +
            "]")
    val result = CountSquares_1277.countSquares(matrix)
    result.printSelf()
}