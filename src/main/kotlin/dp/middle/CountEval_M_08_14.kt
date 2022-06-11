package dp.middle

object CountEval_M_08_14 {
    var dp: Array<Array<IntArray>>? = null
    fun countEval(s: String, result: Int): Int {
        if (s.isEmpty()) return 0
        val len = s.length
        dp = Array(len + 1) {
            Array(len + 1) {
                IntArray(2) { -1 }
            }
        }
        return dfs(s, 0, s.length, result)
    }

    // 包含start 不包含 end
    fun dfs(s: String, start: Int, end: Int, result: Int): Int {
        if (dp!![start][end][result] >= 0) return dp!![start][end][result]
        if (start >= end) return 0
        if (start + 1 == end) {
            return if (result.toString() == s.substring(start, end)) 1 else 0
        }
        var res = 0

        for (i in start until end) {
            if (s[i] == '0' || s[i] == '1') {
                continue
            }
            when (s[i]) {
                '&' -> {
                    if (result == 0) {
                        val left = dfs(s, start, i, 0)
                        val right = dfs(s, i + 1, end, 0)
                        val leftOne = dfs(s, start, i, 1)
                        val rightONe = dfs(s, i + 1, end, 1)
                        res += left * rightONe + right * leftOne + left * right
                    } else {
                        val leftOne = dfs(s, start, i, 1)
                        val rightONe = dfs(s, i + 1, end, 1)
                        res += leftOne * rightONe
                    }
                }
                '|' -> {
                    val left = dfs(s, start, i, 0)
                    val right = dfs(s, i + 1, end, 0)
                    val leftOne = dfs(s, start, i, 1)
                    val rightONe = dfs(s, i + 1, end, 1)
                    if (result == 0) {
                        res += right * left
                    } else {
                        res += left * rightONe + right * leftOne + leftOne * rightONe
                    }
                }
                '^' -> {
                    val left = dfs(s, start, i, 0)
                    val right = dfs(s, i + 1, end, 0)
                    val leftOne = dfs(s, start, i, 1)
                    val rightONe = dfs(s, i + 1, end, 1)
                    if (result == 0) {
                        res += right * left + rightONe * leftOne
                    } else {
                        res += left * rightONe + right * leftOne
                    }
                }
            }
        }
        dp!![start][end][result] = res
        return res
    }
}

fun main() {
    val ss = listOf("0&0&0&1^1|0")
    val rs = listOf(1)
    for (s in ss) {
        for (r in rs) {
            val re = CountEval_M_08_14.countEval(s, r)
            println("s:$s r:$r -> $re")
        }
    }

}