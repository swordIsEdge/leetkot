package jzof

object JZ48 {
    fun lengthOfLongestSubstring(s: String): Int {
        // write code here
        val map = mutableMapOf<Char, Int>()
        var max = 0
        var start = 0

        for ((index, char) in s.toCharArray().withIndex()) {
            val lastIndex = map[char]
            lastIndex?.let { if (it >= start) start = lastIndex + 1 }
            map[char] = index
            max = maxOf(max, index - start + 1)
        }
        return max
    }
}

fun main() {
    val resu = JZ48.lengthOfLongestSubstring("pwwkew")
    print(resu)
}