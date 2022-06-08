package middle

import kotlin.math.abs

object FractionToDecimal {
    fun fractionToDecimal(numerator: Int, denominator: Int): String {
        if (numerator == 0) return "0"
        val result = StringBuilder()
        var sign = true
        if (numerator < 0) sign = false
        if (denominator<0) sign = !sign
        var x = abs( numerator.toLong())
        var quotient: Long
        var fronPoint = true
        val denominator = abs(denominator.toLong())
        val map = hashMapOf<Long, Int>()
        var pointIndex = 0
        var afterPointIndex = -1
        while (x > 0) {
            afterPointIndex++
            if (!fronPoint) {
                if (map.containsKey(x)) { //检测到循环，直接跳出
                    val startIndex = map[x]!!
                    result.insert(pointIndex + startIndex + 1, '(')
                    result.append(')')
                    return (if (!sign) "-" else "") +result.toString()

                } else {
                    map[x] = afterPointIndex
                }
            }
            quotient = x / denominator
            x %= denominator
            if (quotient == 0L && fronPoint) {
                if (result.isEmpty()) result.append('0')
                result.append('.')
                pointIndex = result.lastIndex
                fronPoint = false
                afterPointIndex = -1
            } else {
                result.append(quotient)
            }
            if (!fronPoint) {
                x *= 10
            }
        }
        return (if (!sign) "-" else "") +result.toString()

    }
}

fun main() {
    val r = intArrayOf(-50, 4, 4)
    var r2 = intArrayOf(8, 2, 333)
    for (i in r2.indices) {
        println(FractionToDecimal.fractionToDecimal(r[i], r2[i]))
    }
}