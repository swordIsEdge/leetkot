package dp.middle

object CuttingRope_jzof_II_14 {
    val modBase = 1000000007
    fun cuttingRope(n: Int): Int {
        var x = n
        if (n < 4) return n - 1
        var res = 1L
        while (x > 4) {
            res = res * 3 % modBase
            x -= 3
        }
        return (x * res % modBase).toInt()

    }

    fun cuttingRope2(n: Int): Int {
        //贪心算法  可以通过数学证明得知当等于3的绳子段数越多，乘积越大
        var x = n
        if (x < 4) {
            return x - 1
        }
        var res: Long = 1
        while (x > 4) {
            res = res * 3 % modBase
            x -= 3
        }
        return (res * x % modBase).toInt()
    }
}

fun main() {
    println(CuttingRope_jzof_II_14.cuttingRope(120))
}