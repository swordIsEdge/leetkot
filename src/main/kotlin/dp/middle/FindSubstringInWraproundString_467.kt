package dp.middle

import common.printSelf

object FindSubstringInWraproundString_467 {
    fun findSubstringInWraproundString(p: String): Int {
        val max = IntArray(26)
        val dp = IntArray(26)
        max[p[0] - 'a'] = 1
        dp[p[0] - 'a'] = 1
        var index = 1
//        println(p[0])
//        max.printSelf()
        while (index < p.length) {
            val c = p[index]
//            println(c)
            if ((p[index - 1] + 1 - 'a') % 26 == c - 'a') {
                dp[c - 'a'] = dp[(c - 'a' + 25) % 26] + 1
            } else {
                dp[c - 'a'] = 1
            }
//            max.printSelf()
            max[c - 'a'] = maxOf(max[c - 'a'], dp[c - 'a'])
            index++
        }
        return max.sum()
    }
}

fun main() {
    println(FindSubstringInWraproundString_467.findSubstringInWraproundString("cdefghefghijklmnopqrstuvwxmnijklmnopqrstuvbcdefghijklmnopqrstuvwabcddefghijklfghijklmabcdefghijklmnopqrstuvwxymnopqrstuvwxyz"))
}