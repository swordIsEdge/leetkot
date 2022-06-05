package dp.easy

object MinCostClimbingStairs_88 {
    fun minCostClimbingStairs(cost: IntArray): Int {
        if (cost.size < 2) return 0
        val dp = IntArray(cost.size + 1) { Int.MAX_VALUE }
        dp[0] = 0
        dp[1] = 0
        for (i in 2..cost.size) {
            dp[i] = minOf(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2])
        }
        return dp[cost.size]
    }
}

fun main() {
    val r = MinCostClimbingStairs_88.minCostClimbingStairs(intArrayOf(1, 100))
    println(r)
}