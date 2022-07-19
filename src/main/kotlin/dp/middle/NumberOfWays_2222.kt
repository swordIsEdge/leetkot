package dp.middle

import common.printSelf

object NumberOfWays_2222 {

    fun numberOfWays(s: String): Long {
        val len = s.length
        val oneCount = s.count { it == '1' }
        val zeroCount = len - oneCount
        var tmpOneCount = 0L
        var result = 0L
        for ((index, char) in s.withIndex()) {
            if (char == '0') {
                result += tmpOneCount * (oneCount - tmpOneCount)
            } else {
                val tmpZeroCount = index - tmpOneCount
                result += tmpZeroCount * (zeroCount - tmpZeroCount)
                tmpOneCount++
            }
        }
        return result
    }

    fun numberOfWaysDP(s: String): Long {
        val ba = BooleanArray(s.length) { s[it] == '0' }
        val dp1 = Array(s.length) { LongArray(2) { 0 } }
        val dp2 = Array(s.length) { LongArray(2) { 0 } }
        val dp3 = Array(s.length) { LongArray(2) { 0 } }
        for ((index, isZero) in ba.withIndex()) {
            when (index) {
                0 -> {
                    if (isZero) {
                        dp1[0][0] = 1
                    } else {
                        dp1[0][1] = 1
                    }
                }
                else -> {
                    if (isZero) {
                        dp1[index][0] = 1 + dp1[index - 1][0]
                        dp1[index][1] = dp1[index - 1][1]
                        dp2[index][0] = dp2[index - 1][0] + dp1[index - 1][1]
                        dp2[index][1] = dp2[index - 1][1]
                        dp3[index][0] = dp3[index - 1][0] + dp2[index - 1][1]
                        dp3[index][1] = dp3[index - 1][1]
                    } else {
                        dp1[index][1] = 1 + dp1[index - 1][1]
                        dp1[index][0] = dp1[index - 1][0]
                        dp2[index][1] = dp2[index - 1][1] + dp1[index - 1][0]
                        dp2[index][0] = dp2[index - 1][0]
                        dp3[index][1] = dp3[index - 1][1] + dp2[index - 1][0]
                        dp3[index][0] = dp3[index - 1][0]
                    }
                }
            }
        }
        return dp3[s.length - 1].sum()
    }
}

fun main() {
    val s = "001101"
    NumberOfWays_2222.numberOfWays(s).printSelf()
}