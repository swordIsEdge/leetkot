package middle

import java.util.*

object FindAndReplacePattern_890 {
    fun findAndReplacePattern(words: Array<String>, pattern: String): List<String> {
        val len = pattern.length
        val words = words.filter { it.length == len }
        val dictp = IntArray(128) { -1 }
        val dictw = IntArray(128) { -1 }

        return words.filter {
            Arrays.fill(dictp, -1)
            Arrays.fill(dictw, -1)
            for ((i, c) in it.withIndex()) {
                val d = pattern[i]
                if (dictp[d.toInt()] < 0 && dictw[c.toInt()]<0) {
                    dictp[d.toInt()] = c.toInt()
                    dictw[c.toInt()] = d.toInt()
                } else {
                    if (dictp[d.toInt()] != c.toInt() || dictw[c.toInt()]!=d.toInt()) {
                        return@filter false
                    }

                }
            }
            true
        }
    }
}