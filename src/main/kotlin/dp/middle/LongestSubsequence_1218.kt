package dp.middle

import common.printSelf

object LongestSubsequence_1218 {
    fun longestSubsequence(arr: IntArray, difference: Int): Int {
        val dp = IntArray(40002)
        var result = 1
        for (i in arr) {
            val curIndex = i + 20001
            val tmp = dp[curIndex - difference] + 1
            result = maxOf(result, tmp)
//            println("$i -> $tmp")
            dp[curIndex] = tmp
        }
        return result
    }
}

fun main() {
    val arr = intArrayOf(1, 5, 7, 8, 5, 3, 4, 2, 1)
    val dif = -2
    val res = LongestSubsequence_1218.longestSubsequence(arr, dif)
    res.printSelf()
}