package dp.easy

object MovingCount_offer_13 {
    fun movingCount(m: Int, n: Int, k: Int): Int {
        val map = IntArray(maxOf(m, n) + 1) { getSum(it) }
        val dp = Array(m) { IntArray(n) { 0 } }

        var ans = 0
        dp[0][0] = if (k >= 0) 1 else 0
        ans += dp[0][0]

        for (i in 1 until n) {
            dp[0][i] = if (map[i] <= k && dp[0][i - 1] > 0) 1 else 0
            ans += dp[0][i]
        }
        for (i in 1 until m) {
            dp[i][0] = if(map[i]<=k && dp[i-1][0]>0) 1 else 0
            ans += dp[i][0]
            for (j in 1 until n) {
                dp[i][j] = if (map[i] + map[j] <= k && (dp[i - 1][j] > 0 || dp[i][j - 1] > 0)) 1 else 0
                ans += dp[i][j]
            }
        }
        return ans
    }

    fun getSum(n: Int): Int {
        var sum = 0
        var x = n
        while (x > 0) {
            sum += (x % 10)
            x /= 10
        }
        return sum
    }
}

fun main() {
    val r = MovingCount_offer_13.movingCount(3, 2, 18)
    println(r)
}