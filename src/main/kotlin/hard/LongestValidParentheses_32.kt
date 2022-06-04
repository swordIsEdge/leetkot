package hard

object LongestValidParentheses_32 {
    fun longestValidParentheses(s: String): Int {
        if (s.length < 2) return 0
        val dp = IntArray(s.length) { 0 }
        var max = 0
        for (i in 1 until s.length) {
            val c = s[i]
            if (c == '(') continue
            val lastIndex = i - dp[i - 1] - 1
            dp[i] = if (lastIndex >= 0) {
                if (s[lastIndex] == '(') {
                    dp[i - 1] + 2 + (if (lastIndex - 1 >= 0) dp[lastIndex - 1] else 0)
                } else {
                    0
                }
            } else {
                0
            }
            max = maxOf(max, dp[i])
        }
        return max
    }
}

fun main() {
    val result = LongestValidParentheses_32.longestValidParentheses(")()())")
    println(result)
}