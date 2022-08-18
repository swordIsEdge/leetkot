package dp.middle

import common.printSelf

object CountSubstrings_1638 {
    fun countSubstrings(s: String, t: String): Int {
        val lens = s.length
        val lent = t.length
        if (lens > lent) return countSubstrings(t, s)

        if (lens == 1) {
            val sc = s[0]
            var count = 0
            for (c in t) {
                if (c != sc) {
                    count++
                }
            }
            return count
        }




        val toTail = Array(lens) { IntArray(lent) }
        val fromHead = Array(lens) { IntArray(lent) }

        val tTail = t[lent - 1]
        for (i in 0 until lens) {
            val sTmp = s[i]
            if (sTmp == tTail) {
                toTail[i][lent - 1] = 1
            }
        }
        val sTail = s[lens - 1]
        for (j in 0 until lent) {
            val tTmp = t[j]
            if (tTmp == sTail) {
                toTail[lens - 1][j] = 1
            }
        }
        for (i in lens - 2 downTo 0) {
            val sTmp = s[i]
            for (j in 0 until lent - 1) {
                val tTmp = t[j]
                if (sTmp == tTmp) {
                    toTail[i][j] = 1 + toTail[i + 1][j + 1]
                }
            }
        }
        val tHead = t[0]
        for (i in 0 until lens) {
            val sTmp = s[i]
            if (sTmp == tHead) {
                fromHead[i][0] = 1
            }
        }
        val sHead = s[0]
        for (j in 0 until lent) {
            val tTmp = t[j]
            if (sHead == tTmp) {
                fromHead[0][j] = 1
            }
        }
        for (i in 1 until lens) {
            val sTmp = s[i]
            for (j in 1 until lent) {
                val tTmp = t[j]
                if (sTmp == tTmp) {
                    fromHead[i][j] = fromHead[i - 1][j - 1] + 1
                }
            }
        }


        var result = 0
        for (i in 0 until lens) {
            val tmps = s[i]
            for (j in 0 until lent) {
                val tmpt = t[j]
                if (tmps != tmpt) {
                    val left = if (i == 0 || j == 0) 0 else fromHead[i - 1][j - 1]
                    val right = if (i == lens - 1 || j == lent - 1) 0 else toTail[i + 1][j + 1]
                    result += (left + 1) * (right + 1)
//                    println("s[$i] = ${s[i]}, t[$j]=${t[j]}, left = $left, right = $right")
                }
            }
        }
        return result

    }
}

fun main() {
    val s = "abe"
    val t = "bbc"
    val res = CountSubstrings_1638.countSubstrings(s, t)
    res.printSelf()
}