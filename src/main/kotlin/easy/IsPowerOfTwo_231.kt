package easy

import kotlin.math.abs

object IsPowerOfTwo_231 {
    fun isPowerOfTwo(n: Int): Boolean {
        if (n==Int.MIN_VALUE) return false
        val  n = abs(n)
        var count = 0
        for (i in 0..31) {
            if ((n shr i) and 0b1 != 0) {
                count++
            }
        }
        return count==1

    }
}