package dp.middle

import common.printSelf

class MinDistance_583 {
    var cache = Array<Array<String?>>(0) { arrayOf() }
    fun minDistance(word1: String, word2: String): Int {
        cache = Array(word1.length) { Array(word2.length) { null as String? } }
        val result = longestSubSuquenece(word1, word2, 0, 0)
        return word1.length + word2.length - (result.length shl 1)

    }

    fun longestSubSuquenece(w1: String, w2: String, index1: Int, index2: Int): String {
        if (w1.length == index1 || w2.length == index2) {
            return ""
        }
        if (cache[index1][index2] != null) {
            return cache[index1][index2]!!
        }
        val c1 = w1[index1]
        val c2 = w2[index2]
        val s = if (c1 == c2) {
            c1 + longestSubSuquenece(w1, w2, index1 + 1, index2 + 1)
        } else {
            val s1 = longestSubSuquenece(w1, w2, index1 + 1, index2)
            val s2 = longestSubSuquenece(w1, w2, index1, index2 + 1)
            if (s1.length > s2.length) {
                s1
            } else s2
        }
        cache[index1][index2] = s
        return s
    }
}

fun main() {
    val s1 = "leetcode"
    val s2 = "etco"
    val res = MinDistance_583().minDistance(s1, s2)
    res.printSelf()
}