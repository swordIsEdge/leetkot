package middle

import common.printSelf

object ConstructArray_667 {
    fun constructArray(n: Int, k: Int): IntArray {
        if (k + 1 > n) return intArrayOf()
        if (k + 1 == n) return buildK(k).toIntArray()
        else {
            val kplusone = buildK(k) // 已经有了k+1个
            val remain = (n downTo k + 2).toList()
            return remain.plus(kplusone).toIntArray()
        }
    }

    fun buildK(k: Int): List<Int> {
        val res = mutableListOf<Int>()
        val sum = k + 2
        for (i in 1..k) {
            if (sum < i shl 1) {
                break
            }
//            println("i = $i, add ${sum - i}")
            res.add(sum - i)
            if (sum <= i shl 1) {
                break
            }
            res.add(i)
//            println("i = $i, add ${i}")

        }
        return res
    }
}

fun main() {
    val n = 5
    for (k in 1..4) {
        val res = ConstructArray_667.constructArray(n, k)
        res.printSelf()
    }
}