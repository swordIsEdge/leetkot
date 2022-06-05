package middle

object NumSquares_279 {
    fun numSquares(n: Int): Int {
        val dp = IntArray(n + 1) { n }
        dp[0] = 0
        for (i in 1..n) {
                      var min = i - 1
            var j = 1

            while (j * j <= i) {
                min = minOf(min, dp[i - j*j])
                j++
            }
            dp[i] = min + 1
        }
        return dp[n]
    }
}

fun main() {
    val r = NumSquares_279.numSquares(12)
    println(r)
}