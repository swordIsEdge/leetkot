package hard

object AlienOrder_JZII_114 {
    fun alienOrder(words: Array<String>): String {
        if (words.isEmpty()) return ""
        val (hasAppear, inDegree, path) = buildMatrix(words) ?: return ""
        val result = mutableListOf<Char>()
        val counts = hasAppear.count { it }
        while (result.size < counts) {
            var hasNew = false
            for (i in 0..25) {
                if (hasAppear[i] && inDegree[i] == 0) {
                    result.add('a' + i)
                    path[i].forEach { c -> inDegree[c - 'a']-- }
                    hasAppear[i] = false
                    hasNew = true
                }
            }
            if (!hasNew) {
                return ""
            }
        }
        return String(result.toCharArray())
    }

    fun buildMatrix(words: Array<String>): Triple<BooleanArray, IntArray, Array<MutableSet<Char>>>? {
        val hasAppear = BooleanArray(26) { false }
        val inDegree = IntArray(26) { 0 }
        val path = Array<MutableSet<Char>>(26) { hashSetOf() }

        words.map { it.toCharArray().toList() }.flatten().forEach { hasAppear[it - 'a'] = true }

        for (i in 1 until words.size) {
            val s1 = words[i - 1]
            val s2 = words[i]
            if (s1 == s2) continue

            val minLen = minOf(s1.length, s2.length)
            var hasNewPath = false
            for (j in 0 until minLen) {
                if (s1[j] != s2[j]) {
                    if (!path[s1[j] - 'a'].contains(s2[j])) {
                        path[s1[j] - 'a'].add(s2[j])
                        inDegree[s2[j] - 'a']++
                    }
                    hasNewPath = true
                    break
                }
            }
            if (!hasNewPath && s1.length > s2.length) {
                return null
            }
        }
        return Triple(hasAppear, inDegree, path)
    }
}

fun main() {
    val result = AlienOrder_JZII_114.alienOrder(
        arrayOf(
            "ac", "ab", "zc", "zb"
        )
    )
    println(result)
}