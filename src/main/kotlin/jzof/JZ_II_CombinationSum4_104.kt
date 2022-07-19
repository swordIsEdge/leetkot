package jzof

import common.printSelf

object JZ_II_CombinationSum4_104 {
    fun combinationSum4(nums: IntArray, target: Int): Int {
        nums.sort()
        val len = nums.size
        val dp = Array(len) { IntArray(target + 1) }
//        (0 until len).forEach { dp[it][0] = 1 }
        for (j in 1..target) {
            for (i in 0 until len) {
                val tmpNum = nums[i]
                if (j < tmpNum) break
                if (j == tmpNum) {
                    dp[i][j] = 1
                } else {
                    for (k in 0 until len) {
                        dp[i][j] += dp[k][j - tmpNum]
                    }

                }
//                println("dp[$i][$j] = ${dp[i][j]}")
            }
        }
        return (0 until len).map { dp[it][target] }.sum()
    }
}

fun main() {
    JZ_II_CombinationSum4_104.combinationSum4(intArrayOf(1, 2, 3), 4).printSelf()
}