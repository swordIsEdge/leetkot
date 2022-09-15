package middle

import common.printSelf

object MaximumSwap_670 {
    fun maximumSwap(num: Int): Int {
        if (num <= 11) return num
        val snum = num.toString().map { it - '0' }.toIntArray()
        val len = snum.size
        val dp = IntArray(len)
        for (i in len - 1 downTo 0) {
            val n = snum[i]
            if (i == len - 1) {
                dp[i] = i
            } else {
                dp[i] = if (n > snum[dp[i + 1]]) {
                    i
                } else {
                    dp[i + 1]
                }
            }
        }

        for (i in 0 until len) {
            if (snum[i] < snum[dp[i]]) {
                val j = dp[i]
                val tmp = snum[i]
                snum[i] = snum[j]
                snum[j] = tmp
                break
            }
        }
        val ar = snum.map { (it + '0'.code).toChar() }.toCharArray()
        return String(ar).toInt()
    }
}

fun main() {
    val num = 1993
    val res = MaximumSwap_670.maximumSwap(num)
    res.printSelf()
}