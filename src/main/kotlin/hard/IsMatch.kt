package hard

object IsMatch {
    fun isMatch(s: String, p: String): Boolean {
        val keys = mutableListOf<K>()
        var i = 0
        while (i < p.length) {
            val c = p[i]
            when (c) {
                '*' -> return false
                '.' -> {
                    if (i < p.length - 1 && p[i + 1] == '*') {
                        keys.add(K.ManyAnyChar())
                        i += 1
                    } else {
                        keys.add(K.AnyChar())
                    }
                }
                else -> {
                    if (i < p.length - 1 && p[i + 1] == '*') {
                        keys.add(K.ManyChar(c))
                        i += 1
                    } else {
                        keys.add(K.SpecifiedChar(c))
                    }
                }
            }
            i++
        }

        return dfs(s, 0, keys, 0)
    }

    fun dfs(s: String, sIndex: Int, keys: MutableList<K>, keyIndex: Int): Boolean {
        if (sIndex == s.length && keyIndex == keys.size) return true
        if (keyIndex == keys.size) return false
        if (s.length == sIndex) {
            if (keys[keyIndex] is K.ManyAnyChar || keys[keyIndex] is K.ManyChar) {
                return dfs(s, sIndex, keys, keyIndex + 1)
            } else {
                return false
            }
        }
        val k = keys[keyIndex]
        when (k) {
            is K.SpecifiedChar -> {
                val c = k.c
                return if (s[sIndex] != c) {
                    false
                } else {
                    dfs(s, sIndex + 1, keys, keyIndex + 1)
                }
            }
            is K.AnyChar ->
                return dfs(s, sIndex + 1, keys, keyIndex + 1)
            is K.ManyChar -> {
                // 匹配0个
                val matchZero = dfs(s, sIndex, keys, keyIndex + 1)
                if (matchZero) return true
                for (i in sIndex until s.length) {
                    if (s[i] == k.c) {
                        val testResult = dfs(s, i + 1, keys, keyIndex + 1)
                        if (testResult) return true
                    } else {
                        return false
                    }
                }
                return false
            }
            is K.ManyAnyChar -> {
                for (i in sIndex..s.length) {
                    val testResult = dfs(s, i, keys, keyIndex + 1)
                    if (testResult) return true
                }
                return false
            }
        }

    }

    sealed class K{
        class SpecifiedChar(val c: Char) : K()
        class AnyChar : K()
        class ManyChar(val c: Char) : K()
        class ManyAnyChar : K()
    }


}

fun main() {
    val r = IsMatch.isMatch("aaab", "a.*ab.*")
    println(r)
}