package dp.middle

import common.printSelf

object MinimumDeletions_1653 {
    fun minimumDeletions(s: String): Int {
        val len = s.length
        val left = IntArray(len)
        val right = IntArray(len)
        for ((index, char) in s.withIndex()) {
            if (index == 0) {
                left[0] = if (char == 'b') 1 else 0
            } else {
                left[index] = (if (char == 'b') 1 else 0) + left[index - 1]
            }
        }
        for (index in len - 1 downTo 0) {
            val char = s[index]
            if (index == len - 1) {
                right[index] = if (char == 'a') 1 else 0
            } else {
                right[index] = right[index + 1] + (if (char == 'a') 1 else 0)
            }
        }
        var min = len
        for (i in 0..len) {
            if (i == 0) {
                min = minOf(min, right[0])
            }
            if (i == len) {
                min = minOf(min, left[len - 1])
            }
            if (i != 0 && i != len) {
                min = minOf(min, left[i - 1] + right[i])
            }
        }
        return min

    }
}

fun main() {
    val s = "bbaaaaabb"
    val res = MinimumDeletions_1653.minimumDeletions(s)
    res.printSelf()
}