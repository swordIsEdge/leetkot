package jzof

object JZ69 {
    fun jumpFloor(number: Int): Int  {
        // write code here
        val dp = IntArray(number)

        if (number == 1) {
            return 1
        }
        if (number == 2) {
            return 2
        }
        dp[0] = 1
        dp[1] = 2
        for (i in 2..number - 1) {
            dp[i] = dp[i - 1] + dp[i - 2]

        }
        return dp[number-1]
    }
}