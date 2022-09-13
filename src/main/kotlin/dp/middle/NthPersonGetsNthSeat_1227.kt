package dp.middle

import common.printSelf

object NthPersonGetsNthSeat_1227 {
    fun nthPersonGetsNthSeat(n: Int): Double {
        if (n == 1) return 1.0
        val dp = DoubleArray(n + 1)
        for (i in 1..n) {
            if (i == 1) {
                dp[i] = 1.0 / n
            } else {
                dp[i] = dp[i - 1] + (1 - dp[i - 1]) * (1 - 1.0 / (n - i + 1))
            }
        }
        return dp[n]
    }
    fun test() {

    }
}

fun main() {
    val res = NthPersonGetsNthSeat_1227.nthPersonGetsNthSeat(3).printSelf()
}