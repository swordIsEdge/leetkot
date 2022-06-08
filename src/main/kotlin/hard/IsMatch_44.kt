package hard

object IsMatch_44 {
    var cache: Array<IntArray> = arrayOf()
    fun isMatch(s: String, p: String): Boolean {
        if (s.isEmpty() && p.isEmpty()) return true
        if (p.isEmpty()) return false
        cache = Array(s.length + 1) { IntArray(p.length + 1) { -1 } }
        return dfs(s, p, 0, 0)
    }

    fun dfs(s: String, p: String, sIndex: Int, pIndex: Int): Boolean {
        if (cache[sIndex][pIndex] >= 0) {
            return cache[sIndex][pIndex] == 1
        }
        if (sIndex == s.length) {
            if (pIndex == p.length) {
                return true
            } else {
                val h = HashSet(p.substring(pIndex).toList())
                return (h.size == 1 && h.contains('*'))
            }
        }
        if (pIndex == p.length) return false
        val sc = s[sIndex]
        val pc = p[pIndex]
        return when (pc) {
            '?' -> {
                val t = dfs(s, p, sIndex + 1, pIndex + 1)
                cache[sIndex + 1][pIndex + 1] = if (t) 1 else 0
                t

            }
            '*' -> {
                for (i in s.length downTo sIndex) {
                    val tmp = dfs(s, p, i, pIndex + 1)
                    cache[i][pIndex + 1] = if (tmp) 1 else 0

                    if (tmp) return true
                }
                return false
            }
            else -> {
                if (sc != pc) {
                    false
                } else {
                    val t = dfs(s, p, sIndex + 1, pIndex + 1)
                    cache[sIndex + 1][pIndex + 1] = if (t) 1 else 0
                    t
                }
            }
        }
    }
}

fun main() {
    val m = IsMatch_44.isMatch("acdcb", "a*c?b")
    print(m)
}