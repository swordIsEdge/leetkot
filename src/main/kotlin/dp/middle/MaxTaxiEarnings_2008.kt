package dp.middle

import common.parserArrayIntArray
import common.printSelf

object MaxTaxiEarnings_2008 {
    fun maxTaxiEarnings(n: Int, rides: Array<IntArray>): Long {
        for (ride in rides) {
            ride[2] += ride[1] - ride[0]
        }
        val dp = LongArray(n + 1)
        rides.sortBy { it[1] }
        var index = 0
        for (i in 0..n) {
            if (i>0) dp[i] = dp[i-1]
            if (index < rides.size && rides[index][1] == i) {
                while (index < rides.size && rides[index][1] == i) {
                    dp[i] = maxOf(dp[i], rides[index][2] + dp[rides[index][0]])
                    index++
                }
            } else if (i == 0) {
                continue
            } else {
                dp[i] = dp[i - 1]
            }
        }
        return dp[n]
    }
}

fun main() {
    val n = 10
    val s = "[[9,10,2],[4,5,6],[6,8,1],[1,5,5],[4,9,5],[1,6,5],[4,8,3],[4,7,10],[1,9,8],[2,3,5]]"
    val rides = parserArrayIntArray(s)
    val res = MaxTaxiEarnings_2008.maxTaxiEarnings(n, rides)
    res.printSelf()
}