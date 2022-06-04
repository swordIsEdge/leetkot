package medium

object FindTargetSumWays_494 {
    fun findTargetSumWays(nums: IntArray, target: Int): Int {
        if (nums.isEmpty()) return 0
        val sum = nums.sum()
        if (sum < target) return 0
        val neg = (sum - target) shr 1
        nums.sort()
        val dp = Array(nums.size) { IntArray(neg + 1) { 0 } }
        dp[0][0] = 1
        if (nums[0] <= neg) dp[0][nums[0]] = 1
        for (index in 1 until nums.size) {
            dp[index][0] = 1
            val newItem = nums[index]
//            if (newItem > neg) {
//                return dp[index - 1][neg]
//            }

            for (i in 1..neg) {
                dp[index][i] = if (i < newItem) {
                    dp[index - 1][i]
                } else {
                    dp[index - 1][i] + dp[index - 1][i - newItem]
                }
            }
        }
        return dp[nums.size - 1][neg]
    }
}

fun main() {
    val result = FindTargetSumWays_494.findTargetSumWays(intArrayOf(1,0), 1)
    println(result)
}