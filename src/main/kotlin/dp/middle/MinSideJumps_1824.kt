package dp.middle

import common.parserIntArray
import common.printSelf

object MinSideJumps_1824 {
    fun minSideJumps(obstacles: IntArray): Int {
        val len = obstacles.size
        val dp = Array(len) { IntArray(3) }
        dp[0][0] = 1
        dp[0][1] = 0
        dp[0][2] = 1
        for (i in 1 until len) {
            val block = obstacles[i]
            for (j in 0..2) {
                dp[i][j] = dp[i - 1][j]
            }
            if (block != 0) {
                dp[i][block - 1] = Int.MAX_VALUE
            }
            val withStep = minOf(minOf(dp[i][0], dp[i][1]), dp[i][2]) + 1
            dp[i][0] = minOf(dp[i][0], withStep)
            dp[i][1] = minOf(dp[i][1], withStep)
            dp[i][2] = minOf(dp[i][2], withStep)
            if (block != 0) {
                dp[i][block - 1] = Int.MAX_VALUE
            }
        }
        val min = minOf(minOf(dp[len - 1][0], dp[len - 1][1]), dp[len - 1][2])
        return min
    }
}

fun main() {
    val s = "[0,2,1,0,3,0]"
    val obstacles = parserIntArray(s)
    val res = MinSideJumps_1824.minSideJumps(obstacles)
    res.printSelf()
}