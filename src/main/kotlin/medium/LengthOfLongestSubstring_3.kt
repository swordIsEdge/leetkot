package medium

private class LengthOfLongestSubstring {
    fun lengthOfLongestSubstringOld(s: String): Int {
        val map = mutableMapOf<Char, Int>()
        var max = 0
        var i = 0
        for ((j, c) in s.toCharArray().withIndex()) {
            if (map.containsKey(c)) {
                i = maxOf(map[c]!! + 1, i)
            }
            map[c] = j
            max = maxOf(j - i + 1, max)
        }
        return max
    }

    fun lengthOfLongestSubstring(s: String): Int {
        if (s.isEmpty()) {
            return 0
        }

        val charMap = IntArray(128) { -1 }
        var max = 0
        var start = 0
        for ((i, c) in s.toCharArray().withIndex()) {
            if (charMap[c.toInt()] >=0) {
                start = maxOf(charMap[c.toInt()] + 1, start)
            }
            charMap[c.toInt()] = i
            max = maxOf(max, i - start + 1)
        }
        return max
    }
}

fun main() {
    val l = LengthOfLongestSubstring()
    println(l.lengthOfLongestSubstring("abcabcbb"))

}