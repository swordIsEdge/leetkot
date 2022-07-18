package dp.middle

object FindMaxForm_474 {
    var cache = Array(1) { Array(1) { Array(1) { hashSetOf<Int>() } } }
    fun findMaxForm(strs: Array<String>, m: Int, n: Int): Int {
        val counts = strs.map(this::countDigit)
        cache = Array(counts.size + 1) { Array(m + 1) { Array(n + 1) { hashSetOf<Int>() } } }
        dfs(counts, 0, m, n, 0)
        return max
    }

    var max = 0
    fun dfs(counts: List<Pair<Int, Int>>, index: Int, m: Int, n: Int, c: Int) {
        if (cache[index][m][n].contains(c)) {
            return
        }
        cache[index][m][n].add(c)

        if (index >= counts.size) {
            max = maxOf(max, c)
            return
        }
        dfs(counts, index + 1, m, n, c)
        val zero = counts[index].first
        val one = counts[index].second
        if (zero <= m && one <= n) {
            max = maxOf(max, c + 1)
            dfs(counts, index + 1, m - zero, n - one, c + 1)
        }
    }


    private fun countDigit(s: String): Pair<Int, Int> {
        val countZero = s.filter { it == '0' }.length
        return countZero to s.length - countZero
    }
}