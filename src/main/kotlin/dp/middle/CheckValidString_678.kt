package dp.middle

import common.printSelf
import kotlin.math.max

object CheckValidString_678 {
    fun checkValidString(s: String): Boolean {
        val first = s[0]
        var min = 0
        var max = 0
        if (first == '(') {
            min = 1
            max = 1
        } else if (first == ')') {
            return false
        } else {
            min = 0
            max = 1
        }
        for (i in 1 until s.length) {
            val c = s[i]
            if (c == '(') {
                min += 1
                max += 1
            } else if (c == ')') {
                min -= 1
                max -= 1
            } else {
                min -= 1
                max += 1
            }

            if (max < 0) {
                return false
            }
            min = max(0, min)
        }
        return min == 0

    }

    fun checkValidStringDP(s: String): Boolean {
        val dp = Array(s.length) { hashSetOf<Int>() }
        for ((index, c) in s.withIndex()) {
            if (index == 0) {
                when (c) {
                    '(' -> dp[0].add(1)
                    ')' -> return false
                    else -> dp[0].addAll(listOf(0, 1))
                }
            } else {
                val last = dp[index - 1]
                when (c) {
                    '(' -> {
                        dp[index].addAll(last.map { it + 1 })
                    }
                    ')' -> {
                        dp[index].addAll(last.map { it - 1 }.filter { it >= 0 })
                    }
                    else -> {
                        dp[index].addAll(last.flatMap { listOf(it, it + 1, it - 1) }.filter { it >= 0 })
                    }
                }
            }
        }
        return dp[s.length - 1].contains(0)

    }

    fun checkValidStringOld(s: String): Boolean {
        val dp = Array(s.length) { Array<Boolean?>(s.length) { null } }
        return checkValid(s, 0, 0, dp)
    }

    fun checkValid(s: String, index: Int, tmp: Int, dp: Array<Array<Boolean?>>): Boolean {
        if (tmp < 0) return false
        if (index == s.length) return tmp == 0
        if (dp[index][tmp] != null) {
            return dp[index][tmp]!!
        }
        val result =
            when (s[index]) {
                '(' -> {
                    checkValid(s, index + 1, tmp + 1, dp)
                }
                ')' -> {
                    checkValid(s, index + 1, tmp - 1, dp)
                }
                else -> {
                    (checkValid(s, index + 1, tmp, dp)
                            || checkValid(s, index + 1, tmp + 1, dp)
                            || checkValid(s, index + 1, tmp - 1, dp))
                }
            }
        dp[index][tmp] = result
        return result
    }
}

fun main() {
    val result = CheckValidString_678.checkValidStringDP("(*))")
    result.printSelf()
}