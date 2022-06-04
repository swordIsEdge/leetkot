package easy

object MyAtoi_8 {
    fun myAtoi(s: String): Int {
        val chars = hashSetOf<Char>('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')
        if (s.isEmpty()) return 0
        var i = -1
        var j = -1
        for (index in s.indices) {
            val c = s[index]
            if (i < 0) {
                when (c) {
                    ' ' -> i = -1
                    '+' -> i = index
                    '-' -> i = index
                    in chars -> {
                        i = index
                        j = index + 1
                    }
                    else -> return 0
                }
            } else if (j < 0) {
                if (c in chars) {
                    j = index + 1
                } else {
                    return 0
                }
            } else {
                if (c in chars) {
                    j = index + 1
                } else {
                    break
                }
            }
        }
        if (i < 0 || j < 0) return 0
        var news = s.substring(i, j)
        val sign = if (news[0] == '-') {
            -1
        } else 1
        news = news.removePrefix("-").removePrefix("+")
        while (news.startsWith("0")) {
            news= news.removePrefix("0")
        }
        if (news.isEmpty()) return 0

        if (news.length > 11) {
            return when (sign) {
                -1 -> Int.MIN_VALUE
                1 -> Int.MAX_VALUE
                else -> Int.MAX_VALUE
            }
        }
        val result = news.toLong()*sign
        return if (result < Int.MIN_VALUE.toLong()) {
            Int.MIN_VALUE
        } else if (result > Int.MAX_VALUE.toLong()) {
            Int.MAX_VALUE
        } else {
            result.toInt()
        }
    }
}

fun main() {
    val r = MyAtoi_8.myAtoi("-9223372036854775809")
    println(r)
}