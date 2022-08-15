package dp.middle

object FirstDayBeenInAllRooms_1997 {
    fun firstDayBeenInAllRooms(nextVisit: IntArray): Int {
        val len = nextVisit.size
        val mod = 1000000007
        val dp = LongArray(len)
        for (i in 1 until len) {
            dp[i] = (dp[i - 1] * 2 - dp[nextVisit[i - 1]] + 2 + mod) % mod
        }
        return dp[len - 1].toInt()
    }
}