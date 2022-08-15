package dp.middle

import common.printSelf

object MaxSumDivThree_1262 {
    fun maxSumDivThree(nums: IntArray): Int {
        val len = nums.size
        val dp = Array(len) { IntArray(3) }
        for ((inx, num) in nums.withIndex()) {
            val rem = num % 3
            if (inx == 0) {
                dp[0][rem] = num
            } else {
                for (i in 0..2) {
                    dp[inx][i] = dp[inx - 1][i]
                }
                dp[inx][rem] = maxOf(num, dp[inx][rem])
                for (i in 0..2) {
                    dp[inx][i] = if (dp[inx - 1][(3 + i - rem) % 3] == 0) dp[inx][i] else maxOf(
                        dp[inx][i],
                        dp[inx - 1][(i + 3 - rem) % 3] + num
                    )
                }
            }
            dp[inx].printSelf()
        }
        return dp[len - 1][0]
    }
}

fun main() {
    val nums = intArrayOf(3,6,5,1,8)
    val res = MaxSumDivThree_1262.maxSumDivThree(nums)
    res.printSelf()
}