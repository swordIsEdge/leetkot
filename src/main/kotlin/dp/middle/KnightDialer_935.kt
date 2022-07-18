package dp.middle

import common.printSelf


object KnightDialer_935 {
    fun knightDialer(n: Int): Int {
        val com = 1000000007
        val numMap = mapOf(
            0 to setOf(4, 6),
            1 to setOf(8, 6),
            2 to setOf(7, 9),
            3 to setOf(8, 4),
            4 to setOf(0,3, 9),
            5 to setOf(),
            6 to setOf(0,1, 7),
            7 to setOf(2, 6),
            8 to setOf(1, 3),
            9 to setOf(2, 4)
        )
        val dp = Array(10) { IntArray(n + 1) }
        (0..9).forEach { dp[it][1] = 1 }
        for (i in 2..n) {
            for (j in 0..9) {
                for (last in numMap[j]!!) {
                    dp[last][i] = (dp[last][i] + (dp[j][i - 1]) % com) % com
                }
            }
        }
        var result = 0
        for (i in 0..9) {
            result = (result + dp[i][n]) % com
        }
        return result
    }
}

fun main() {
    KnightDialer_935.knightDialer(3131).printSelf()
}