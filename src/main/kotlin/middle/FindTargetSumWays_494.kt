package middle

import common.printSelf

object FindTargetSumWays_494 {
    fun findTargetSumWays(nums: IntArray, target: Int): Int {
        if (nums.isEmpty()) return 0
        val sum = nums.sum()
        if (sum < target) return 0
        if ((sum - target) % 2 == 1) return 0
        val neg = (sum - target) shr 1
        nums.sort()
        val len = nums.size
        val dp = Array(len) { IntArray(neg + 1) { 0 } }

        dp[0][0] = 1
        if (nums[0] <= neg) {
            dp[0][nums[0]]++
        }
//        nums.printSelf()
        for (index in 1 until len) {
            dp[index][0] = 1
            val newItem = nums[index]
            for (i in 0..neg) {
                if (i - newItem >= 0) {
                    dp[index][i] = dp[index - 1][i - newItem] + dp[index - 1][i]
                } else {
                    dp[index][i] = dp[index - 1][i]

                }
            }
//            dp[index].printSelf()
        }

        return dp[nums.size - 1][neg]
    }
}

fun main() {
    val result = FindTargetSumWays_494.findTargetSumWays(intArrayOf(1,1,1,1,1), 3)
    println(result)
}