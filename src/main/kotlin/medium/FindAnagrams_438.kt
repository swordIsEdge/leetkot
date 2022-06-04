package medium

object FindAnagrams_438 {
    fun findAnagrams(s: String, p: String): List<Int> {
        if (s.length < p.length) return listOf()
        val counts = IntArray(26) { 0 }
        p.toCharArray().forEach { counts[it - 'a']++ }
        var left = 0
        var right = 0
        var targetLen = p.length
        val result = mutableListOf<Int>()
        while (right < s.length) {
            if (counts[s[right] - 'a'] > 0) {
                counts[s[right++] - 'a']--
                if (right-left==targetLen) result.add(left)
            } else {
                counts[s[left] - 'a']++
                left++
            }
        }
        return result
    }
}