package dp.middle

import common.printSelf
import kotlin.math.max

object LongestArithSeqLength_1027 {
    fun longestArithSeqLength(nums: IntArray): Int {
        val len = nums.size
        var result = 1
        val dp = Array(len) { IntArray(1001){1} }
        for ((index, num) in nums.withIndex()) {
            if (index == 0) {
                for (i in 0 .. 1000) {
                    dp[0][i] = 1
                }
            } else {
                for (i in 0 until index) {
                    val last = nums[i]
                    val diff = last - num
                    val length = dp[i][500 + diff]
                    dp[index][500 + diff] = max(dp[index][500 + diff], length + 1)
                    result = max(result, dp[index][500 + diff])
                }
            }
        }
        return result
    }
}

fun main() {
    LongestArithSeqLength_1027.longestArithSeqLength(
        intArrayOf(
       3,6,9,12
        )
    ).printSelf()
}