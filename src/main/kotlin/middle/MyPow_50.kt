package middle

import kotlin.math.abs

object MyPow_50 {
    fun myPow(x: Double, n: Int): Double {
        if (x==1.0) return 1.0
        if (n==Int.MIN_VALUE) return 0.0
        var result = 1.0
        var tmp = x
        var absN = abs(n)
        while (absN > 0) {
            if (absN and 1 != 0) {
                result *= tmp
            }
            tmp *=tmp
            absN = absN shr 1
        }
        return if (n > 0) result else 1 / result
    }
}