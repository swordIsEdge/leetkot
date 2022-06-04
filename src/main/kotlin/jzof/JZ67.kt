package jzof

object JZ67 {
    fun StrToInt(s: String): Int {
        // write code here
        if (s.isEmpty()) {
            return 0
        }
        var i = 0
        while (i<s.length && s[i] == ' ') {
            i++
        }
        if (i >= s.length) {
            return 0
        }
        val flag = if (s[i] == '+' || s[i] == '-') {
            s[i++] == '+'
        } else true
        var num = 0L
        while (i<s.length && Character.isDigit(s[i]) ) {
            num = num * 10 + (s[i++] - '0')
            if (num > 2147483648L) {
                break
            }
        }
        return if (flag) {
            minOf(num,Int.MAX_VALUE.toLong()).toInt()
        } else {
            maxOf(num * -1,Int.MIN_VALUE.toLong()).toInt()
        }
    }

}

fun main() {
    val res = JZ67.StrToInt("13333744073709551617 ")
    println(res)
}