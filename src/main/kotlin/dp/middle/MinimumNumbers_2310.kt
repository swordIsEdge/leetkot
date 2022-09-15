package dp.middle

import common.printSelf

object MinimumNumbers_2310 {
    fun minimumNumbers(num: Int, k: Int): Int {
        return when {
            num == 0 -> 0
//            k == 0 -> -1
            num < k -> -1
            num%10 == k%10 -> 1
            num % 2 == 1 && k % 2 == 0 -> -1
            k == 5 && num % 5 != 0 -> -1
            else -> {
                val numEnd = num%10
                for (i in 1..10) {
                    val tmpMul = k * i
                    val tmpMulEnd = tmpMul % 10
                    if (tmpMulEnd == numEnd && tmpMul<=num) {
                        return i
                    }
                }
                -1
            }
        }
    }
}

fun main() {
    val num = 58
    val k = 9
    val res = MinimumNumbers_2310.minimumNumbers(num, k)
    res.printSelf()
}
