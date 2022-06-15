package dp.middle

object CountSubstrings_jzof_II_20 {
    fun countSubstrings(s: String): Int {
        if (s.isEmpty()) return 0
        val len = s.length
        var result = 0
        for (i in s.indices) {
            var l = i
            var r = i
            while (l >= 0 && r < len && s[l--] == s[r++]) result++
            l = i
            r = i+1
            while (l >= 0 && r < len && s[l--] == s[r++]) result++
        }
        return result
    }
}