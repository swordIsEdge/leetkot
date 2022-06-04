package easy

object IsAlienSorted_953 {
    fun isAlienSorted(words: Array<String>, order: String): Boolean {
        if (words.isEmpty()) return true
        val dict = IntArray(26) { 0 }
        for ((i, c) in order.withIndex()) {
            dict[c - 'a'] = i
        }
        for (i in 1 until words.size) {
            if (compareString(words[i - 1], words[i], dict) < 0) {
                return false
            }
        }
        return true

    }

    private fun compareString(s1: String, s2: String, dict:IntArray): Int {
        if (s1.isBlank() && s2.isBlank()) {
            return s2.length - s1.length
        }
        if (s1.isBlank()) return 1
        if (s2.isBlank()) return -1
        if (s1 == s2) return 0

        val len = minOf(s1.length, s2.length)
        for (i in 0 until len) {
            val c1 = s1[i]
            val c2 = s2[i]
            if (c1 != c2) {
                return dict[c2-'a']-dict[c1-'a']
            }
        }

        return s2.length - s1.length

    }
}

fun main() {
    val r = IsAlienSorted_953.isAlienSorted(arrayOf("hello","leetcode"), "hlabcdefgijkmnopqrstuvwxyz")
    println(r)
}