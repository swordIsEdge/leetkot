package dp.middle

object TranslateNum_offer_46 {
    fun translateNum(num: Int): Int {
        if (num == 0) {
            return 1
        }
        var x = num
        val bits = mutableListOf<Int>()
        while (x > 0) {
            bits.add(x % 10)
            x /= 10
        }
        bits.reverse()
        val len = bits.size

        val dp = IntArray(len) { 0 }

        dp[0] = 1
        for (i in 1 until len) {
//            val cur = bits[i]
            val last = bits[i - 1]
            val last2 = bits[i - 1] * 10 + bits[i]
            dp[i] = if (last != 0 && last2 <= 25) {
                dp[i - 1] + if (i > 1)  dp[i - 2] else 1
            } else {
                dp[i - 1]
            }
        }
        return dp[len - 1]
    }
}