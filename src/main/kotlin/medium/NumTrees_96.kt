package medium

object NumTrees_96 {
    fun numTrees(n: Int): Int {
        if (n < 2) return 1
        val dp = IntArray(n + 1) { 1 }
        for (index in 2..n) {
            dp[index] = (0 until index).sumOf { dp[it] * dp[index - 1 - it] }
        }
        return dp[n]
    }
}

fun main() {
    val res = NumTrees_96.numTrees(5)
}