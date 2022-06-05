package dp.middle

object Partition_131 {
    val result = mutableListOf<List<String>>()
    var dp = Array(1) { intArrayOf(1) }
    fun partition(s: String): List<List<String>> {
        val len = s.length
        dp = Array(len) { IntArray(len) { -1 } }
        dfs(s, 0, mutableListOf())
        return result
    }

    fun dfs(s: String, index: Int, last: MutableList<String>) {
        if (index >= s.length) {
            result.add(last.toList())
        } else {
            for (i in index until s.length) {
                if (isPalindrome(s, index, i)) {
                    last.add(s.substring(index, i + 1))
                    dfs(s, i + 1, last)
                    last.removeAt(last.size-1)
                }
            }
        }
    }

    fun isPalindrome(s: String, i: Int, j: Int): Boolean {
        if (dp[i][j] >= 0) {
            return dp[i][j] == 1
        }
        val v = if (i > j) {
            1
        } else if (i == j) {
            1
        } else {
            if (s[i] == s[j] && isPalindrome(s, i + 1, j - 1)) 1 else 0
        }
        dp[i][j] = v
        return v == 1
    }

}