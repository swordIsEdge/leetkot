package dataStructure

class FastSquare {
    fun fastPow(base: Int, exp: Int): Int {
        if (base == 0) return 0
        return when (exp) {
            0 -> 1
            1 -> base
            else -> {
                if (exp and 1 == 0) {
                    val f = fastPow(base, exp shr 1)
                    f * f * base
                } else {
                    val f = fastPow(base, exp shr 1)
                    f * f
                }
            }
        }
    }

    //非递归快速幂
    fun qpow(a: Int, n: Int): Int {
        var a = a
        var n = n
        var ans = 1
        while (n != 0) {
            if (n and 1 != 0) //如果n的当前末位为1
                ans *= a //ans乘上当前的a
            a *= a //a自乘
            n = n shr 1 //n往右移一位
        }
        return ans
    }
}