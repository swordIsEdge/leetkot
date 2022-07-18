package dp.middle

import common.printSelf

object RotatedDigits_788 {
    val selfSet = setOf(0, 1, 8)
    val notSelfSet = setOf(2, 5, 6, 9)
    fun rotatedDigits(n: Int): Int {
        val map = mapOf(
            0 to 0,
            1 to 1,
            2 to 2,
            3 to 2,
            4 to 2,
            5 to 5,
            6 to 6,
            7 to 6,
            8 to 8,
            9 to 9
        )
        val ns = n.toString().map { it - '0' }.map { map[it]!! }
        return rotatedDigits(ns)
    }

    fun rotatedDigits(ns: List<Int>): Int {
        var result = 0
        val len = ns.size
        if (len == 0) return 1
        val first = ns[0]
        for (i in 0..first) {
            if (i == first) {
                if (first in notSelfSet) {
                    result += littleCount(ns.subList(1, len))
                } else {
                    result += rotatedDigits(ns.subList(1, len))

                }
            } else if (i == 0) {
                result += rotatedDigits(ns.subList(1, len))
            } else if (i in notSelfSet) {
                result += withNotSelfKey(len - 1)
            } else if (i in selfSet) {
                result += withSelf(len - 1)
            }
        }
        return result
    }

    fun man(n: Int): Int {
        if (n == 1) return 4
        return 4 * withNotSelfKey(n - 1) + 2 * withSelf(n - 1)
        TODO()

    }

    val littleCountMap = mapOf<Int, Int>(
        0 to 1,
        1 to 2,
        2 to 3,
        3 to 3,
        4 to 3,
        5 to 4,
        6 to 5,
        7 to 5,
        8 to 6,
        9 to 7
    )

    fun littleCount(ns: List<Int>): Int {
        val ns = ns.map { littleCountMap[it]!! }
        var result = 1
        for (n in ns) {
            result *= n
        }
        return result

    }

    fun withNotSelfKey(bit: Int): Int {
        var result = 1
        for (i in 1..bit) result *= 7
        return result
    }

    fun withSelf(bit: Int): Int {
        var result = 0
        for (i in bit downTo 1) {
            result += 4 * withNotSelfKey(i - 1)
            result += 3 * withSelf(i - 1)
        }
        return result
    }

}

fun main() {
    RotatedDigits_788.rotatedDigits(10).printSelf()
}