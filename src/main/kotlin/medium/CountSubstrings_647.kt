package medium

object CountSubstrings_647 {
    fun countSubstrings(s: String): Int {
        if (s.isEmpty()) return 0
        var result = 0
        val len = s.length
        for (i in s.indices) {
            var l = i
            var r = i
            while (l >= 0 && r < len && s[l--] == s[r++]) result++
            l = i
            r = i + 1
            while (l >= 0 && r < len && s[l--] == s[r++]) result++

        }
        return result

    }
}