package middle

object Divide_29 {
    fun divide(dividend: Int, divisor: Int): Int {
        TODO()
    }
}
internal class Solution_divide {
    fun divide(dividend: Int, divisor: Int): Int {
        // 考虑被除数为最小值的情况
        var dividend = dividend
        var divisor = divisor
        if (dividend == Int.MIN_VALUE) {
            if (divisor == 1) {
                return Int.MIN_VALUE
            }
            if (divisor == -1) {
                return Int.MAX_VALUE
            }
        }
        // 考虑除数为最小值的情况
        if (divisor == Int.MIN_VALUE) {
            return if (dividend == Int.MIN_VALUE) 1 else 0
        }
        // 考虑被除数为 0 的情况
        if (dividend == 0) {
            return 0
        }

        // 一般情况，使用二分查找
        // 将所有的正数取相反数，这样就只需要考虑一种情况
        var rev = false
        if (dividend > 0) {
            dividend = -dividend
            rev = !rev
        }
        if (divisor > 0) {
            divisor = -divisor
            rev = !rev
        }
        var left = 1
        var right = Int.MAX_VALUE
        var ans = 0
        while (left <= right) {
            // 注意溢出，并且不能使用除法
            val mid = left + (right - left shr 1)
            val check = quickAdd(divisor, mid, dividend)
            if (check) {
                ans = mid
                // 注意溢出
                if (mid == Int.MAX_VALUE) {
                    break
                }
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        return if (rev) -ans else ans
    }

    // 快速乘
    fun quickAdd(y: Int, z: Int, x: Int): Boolean {
        // x 和 y 是负数，z 是正数
        // 需要判断 z * y >= x 是否成立
        var z = z
        var result = 0
        var add = y
        while (z != 0) {
            if (z and 1 != 0) {
                // 需要保证 result + add >= x
                if (result < x - add) {
                    return false
                }
                result += add
            }
            if (z != 1) {
                // 需要保证 add + add >= x
                if (add < x - add) {
                    return false
                }
                add += add
            }
            // 不能使用除法
            z = z shr 1
        }
        return true
    }
}