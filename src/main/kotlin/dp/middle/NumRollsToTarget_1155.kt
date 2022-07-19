package dp.middle

import common.printSelf

object NumRollsToTarget_1155 {
    fun numRollsToTarget(n: Int, k: Int, target: Int): Int {
        val dp = Array(n + 1) { IntArray(target + 1) { 0 } }
        for (i in 1..n) {
            for (j in i..target) {
                for (m in 1..k) {
                    if (m < j) {
                        dp[i][j] += dp[i - 1][j - m]
                    } else if (i==1 && j == m) {
                        dp[i][j]++
                    } else {
                        break
                    }
                    dp[i][j] %= 1000000007
                }
//                println("dp[$i][$j]=${dp[i][j]}")
            }
        }
        return dp[n][target]
    }
}

fun main() {
    NumRollsToTarget_1155.numRollsToTarget(30, 30, 500).printSelf()
}