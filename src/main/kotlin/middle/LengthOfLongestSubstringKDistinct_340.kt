package middle

object LengthOfLongestSubstringKDistinct_340 {
    fun lengthOfLongestSubstringKDistinct(s: String, k: Int): Int {
        if (s.isEmpty()) return 0
        if (k == 0) return 0
        var maxLen = 1
        val cSet = hashSetOf<Char>()
        val count = IntArray(128) { 0 }
        var left = 0
        var right = 1
        cSet.add(s[0])
        count[s[0].code] = 1
        while (left < s.length ) {
            if (cSet.size == k) {
                maxLen = maxOf(maxLen, right - left)
                if (right < s.length) {
                    cSet.add(s[right])
                    count[s[right].toInt() ]++
                    right++
                } else break

            } else if (cSet.size < k) {
                maxLen = maxOf(maxLen, right - left)

                if (right < s.length) {
                    cSet.add(s[right])
                    count[s[right].toInt() ]++
                    right++
                } else break
            } else {
                val r =--count[s[left].toInt() ]
                if (r == 0) {
                    cSet.remove(s[left])
                }
                left++
            }
        }
        return maxLen
    }
}

fun main() {
    val s = LengthOfLongestSubstringKDistinct_340.lengthOfLongestSubstringKDistinct("abee", 1)
}