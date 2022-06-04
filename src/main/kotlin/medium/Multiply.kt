package medium

object Multiply {
    fun multiply(num1: String, num2: String): String {
        if (num1 == "0" || num2 == "0") return "0"
        if (num1 == "1") return num2
        if (num2 == "1") return num1
        val mulResults = num2.withIndex().map { (i, c) -> mul(num1, c, num2.length - 1 - i) }.toTypedArray()
        return add(*mulResults)
    }

    fun mul(num: String, c: Char, zero: Int): String {
        if (c == '0') return "0"
        if (c == '1') return num + ("0".repeat(zero))
        val c = c - '0'
        val result = IntArray(num.length + 1) { 0 }
        var remain = 0
        for ((i, tc) in num.withIndex().reversed()) {
            val tmp = (tc - '0') * c + remain
            result[i + 1] = tmp % 10
            remain = tmp / 10
        }
        if (remain != 0) result[0] = remain
        val s = String(result.map { '0' + it }.toCharArray()).removePrefix("0") + ("0".repeat(zero))
        return s
    }

    fun add(vararg num: String): String {
        var maxLen = 0
        num.map { it.length }.forEach{maxLen = maxOf(maxLen,it) }
        val results = mutableListOf<Int>()
        var remain = 0
        for (i in 0 until maxLen) {
            val sum = num.filter {
                it.length > i
            }.map { it[it.length - 1 - i] - '0' }.sum() + remain
            val tmp = sum % 10
            remain = sum / 10
            results.add(tmp)
        }
        while (remain > 0) {
            results.add(remain % 10)
            remain = remain / 10
        }
        return String(results.reversed().map { '0' + it }.toCharArray())
    }
}

fun main() {
    val s = Multiply.multiply("123", "12")
    println(s)
}