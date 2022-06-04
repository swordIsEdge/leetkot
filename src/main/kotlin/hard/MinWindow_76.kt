package hard

import java.util.*

object MinWindow_76 {
    fun minWindow(s: String, t: String): String {
        if (s.length < t.length) return ""
        val flagChars = t.toSet()
        val tCounts = IntArray(128) { 0 }
        t.forEach { tCounts[it - 'A']++ }
        var minLen = Int.MAX_VALUE
        var minLenStr = ""
        val queue = LinkedList<Int>()
        val sCounts = IntArray(128) { 0 }
        val satifyChars = hashSetOf<Char>()

        var left = 0
        var right = 0
        while (right < s.length && left <= right) {
            val c = s[right]
            if (flagChars.contains(c)) {
                if (right > 0) queue.add(right)
                sCounts[c - 'A']++
                if (sCounts[c - 'A'] >= tCounts[c - 'A']) {
                    satifyChars.add(c)
                }
                while (satifyChars.size >= flagChars.size) {
                    if (right - left + 1 < minLen) {
                        minLen = right - left + 1
                        minLenStr = s.substring(left, right + 1)
                    }
                    if (queue.isEmpty()) break
                    val old = s[left]
                    sCounts[old - 'A']--
                    if (sCounts[old - 'A'] < tCounts[old - 'A']) {
                        satifyChars.remove(
                            old
                        )
                    }
                    left = queue.poll()
                }
            }
            right++
        }

        return minLenStr
    }
}

fun main() {
    val s = MinWindow_76.minWindow("A", "A")
    println(s)
}