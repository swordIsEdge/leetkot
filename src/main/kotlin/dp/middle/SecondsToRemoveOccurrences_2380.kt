package dp.middle

import common.printSelf

object SecondsToRemoveOccurrences_2380 {
    fun secondsToRemoveOccurrences(s: String): Int {
        val len = s.length
        val dp = IntArray(len)
        var oneCount = 0
        for ((index, char) in s.withIndex()) {
            if (index == 0) {
                if (char == '1') {
                    oneCount++
                }
            } else {
                if (char == '1') {
                    oneCount++
                    val tmp = index + 1 - oneCount
                    if (tmp == 0) dp[index] = 0
                    else dp[index] = maxOf(tmp, dp[index - 1] + 1)
                } else {
                    dp[index] = dp[index - 1]
                }
            }
        }
//        dp.printSelf()
        return dp[len - 1]
    }
}

fun main() {
    val s = "011011"
    val res = SecondsToRemoveOccurrences_2380.secondsToRemoveOccurrences(s)
    res.printSelf()
}