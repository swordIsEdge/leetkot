package dp.middle

import common.printSelf

object MinFlips_1888 {
    fun minFlips(s: String): Int {
        val len = s.length
        if (len % 2 == 0) {
            var f = 0
            var se = 0
            for ((index, char) in s.withIndex()) {
                if (char - '0' == index % 2) {
                    se++
                } else {
                    f++
                }
            }
            return minOf(f, se)
        } else {
            val left = IntArray(len)
            val right = IntArray(len)
            for ((index, char) in s.withIndex()) {
                if (index == 0) {
                    left[index] = if (char - '0' == 0) {
                        1
                    } else {
                        0
                    }
                } else {
                    left[index] = if (char - '0' == index%2) {
                        1 + left[index - 1]
                    } else {
                        left[index - 1]
                    }

                }
            }
            for (index in len - 1 downTo 0) {
                val char = s[index]
                if (index == len - 1) {
                    right[index] = if (char - '0' == 0) 1 else 0
                } else {
                    right[index] = if (char - '0' == index % 2) right[index + 1] + 1 else right[index + 1]
                }
            }
            var min = len
            for (i in 0 until len-1) {
                val le = i + 1
                val ri = len - le
                min = minOf(min, le - left[i] + right[i+1])
                min = minOf(min, ri - right[i+1] + left[i])
            }
            min = minOf(min,left[len-1])
            min = minOf(min,len-right[0])
            return min
        }
    }
}

fun main() {
    val s = "01001001101"
    val res = MinFlips_1888.minFlips(s)
    res.printSelf()
}