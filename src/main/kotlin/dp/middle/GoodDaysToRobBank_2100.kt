package dp.middle

import common.printSelf

object GoodDaysToRobBank_2100 {
    fun goodDaysToRobBank(security: IntArray, time: Int): List<Int> {
        val len = security.size
        val left = IntArray(len)
        val right = IntArray(len)
        for (i in 1 until len) {
            left[i] = if (security[i] <= security[i - 1]) {
                left[i - 1] + 1
            } else 0
        }
        for (j in len - 2 downTo 0) {
            right[j] = if (security[j] <= security[j + 1]) {
                right[j + 1] + 1
            } else 0
        }

        val result = mutableListOf<Int>()
        for (i in 0 until len) {
            if (left[i] >= time && right[i] >= time) {
                result.add(i)
            }
        }
        return result
    }
}

fun main() {
    GoodDaysToRobBank_2100.goodDaysToRobBank(
        intArrayOf(1,2,3,4,5,6),
        2
    ).printSelf()
}