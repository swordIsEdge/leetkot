package easy

import common.printSelf

object MaxScore_1422 {
    fun maxScore(s: String): Int {
        val len = s.length
        val left = IntArray(len)
        val right = IntArray(len)
        for (i in 0 until len) {
            if (i == 0) {
                left[0] = if (s[0] == '0') 1 else 0
            } else {
                left[i] = if (s[i] == '0') left[i - 1] + 1 else left[i - 1]
            }
        }
        for (i in len - 1 downTo 0) {
            if (i == len - 1) {
                right[i] = if (s[i] == '1') 1 else 0
            } else {
                right[i] = if (s[i] == '1') right[i + 1] + 1 else right[i + 1]
            }
        }
        var result = -1
        for (i in 0 until len - 1) {
            val tmp = left[i] + right[i + 1]
            result = maxOf(result, tmp)
        }
        return result
    }
}

fun main() {
    val s = "1111"
    val result = MaxScore_1422.maxScore(s)
    result.printSelf()
}