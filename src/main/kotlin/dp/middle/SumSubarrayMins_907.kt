package dp.middle

import common.parserIntArray
import common.printSelf

object SumSubarrayMins_907 {
    fun sumSubarrayMinsSlow(arr: IntArray): Int {
        var result = 0
        val mod = 1000000007
        val len = arr.size
        val dp = IntArray(len) { arr[it] }
        for (i in 0 until len) {
            var last = 0
            for (j in len - 1 - i downTo 0) {
                val cur = dp[j]
                result = (cur % mod + result) % mod
                dp[j] = minOf(dp[j], last)
                last = cur
            }
        }
        return result
    }

    val mod = 1000000007
    fun sumSubarrayMins(arr: IntArray): Int {

        val len = arr.size
        val left = IntArray(len) { 1 }
        val right = IntArray(len) { 1 }
        val stack = mutableListOf<Int>()
        for (i in 0 until len) {
            if (stack.isEmpty()) {
                stack.add(i)
            } else {
                val cur = arr[i]
                while (stack.isNotEmpty() && arr[stack[stack.size - 1]] > cur) {
                    val last = stack.removeAt(stack.size - 1)
                    right[last] = i - last
                }
                if (stack.isEmpty()) {
                    stack.add(i)
                    left[i] = i + 1
                } else {
                    left[i] = i - stack[stack.size - 1]
                    stack.add(i)
                }
            }
        }
        while (stack.isNotEmpty()) {
            val last = stack.removeAt(stack.size - 1)
            right[last] = len - last
        }
        var result = 0
        for (i in 0 until len) {
            result = (result + count(arr[i], left[i], right[i]) % mod) % mod

            val tmp = count(arr[i], left[i], right[i])
        }
        return result
    }

    fun count(value: Int, left: Int, right: Int): Int {
        return if (left == 1 || right == 1) {
            ((left.toLong() * right.toLong()) % mod * value).toInt()
        } else (((left + right - 1) % mod + ((left - 1).toLong() * (right - 1).toLong() % mod) % mod) * value % mod).toInt()
    }
}

fun main() {
    val param = parserIntArray("[11,81,94,43,3]")
    val result = SumSubarrayMins_907.sumSubarrayMins(param)
    result.printSelf()
}