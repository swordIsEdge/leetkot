package dp.middle

import common.printSelf

object WiggleMaxLength_376 {
    fun wiggleMaxLength(nums: IntArray): Int {
        val len = nums.size
        if (len == 1) return 1
        val dp = Array(len) { Array(2) { 0 to 1 } }
        dp[0][0] = nums[0] to 1
        dp[0][1] = nums[0] to 1
//        val i = 0
//        println("$i: ${dp[i][0]}  ${dp[i][1]}")

        for (i in 1 until len) {
            val cur = nums[i]
            dp[i][1] = dp[i - 1][1]
            dp[i][0] = dp[i - 1][0]
            if (cur > dp[i - 1][0].first) {
                dp[i][0] = cur to dp[i - 1][0].second
            } else if (cur < dp[i - 1][0].first) {
                dp[i][1] = cur to dp[i - 1][0].second + 1
            }

            if (cur < dp[i - 1][1].first) {
                dp[i][1] = cur to maxOf(dp[i - 1][1].second, dp[i][1].second)
            }
            if (cur > dp[i - 1][1].first) {
                dp[i][0] = cur to maxOf(dp[i - 1][1].second + 1, dp[1][0].second)
            }
//            println("$i: ${dp[i][0]}  ${dp[i][1]}")
        }
        return maxOf(dp[len - 1][0].second, dp[len - 1][1].second)
    }

}

fun main() {
    WiggleMaxLength_376.wiggleMaxLength(intArrayOf(3, 3, 3, 2, 5)).printSelf()
}