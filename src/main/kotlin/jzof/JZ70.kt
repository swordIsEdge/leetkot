package jzof

object JZ70 {
    fun rectCover(number: Int): Int {
        // write code here
        if (number <= 2) {
            return number
        }
        val dp = IntArray(number + 1)
        dp[1] = 1
        dp[2] = 2
        (3..number).forEach { i -> dp[i] = dp[i - 1] + dp[i - 2] }
        return dp[number]
    }
}

fun main() {
    val r = JZ70.rectCover(4)
    print(r)
}