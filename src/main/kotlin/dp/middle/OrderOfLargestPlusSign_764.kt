package dp.middle

import common.parserArrayIntArray
import common.printSelf

object OrderOfLargestPlusSign_764 {
    fun orderOfLargestPlusSign(n: Int, mines: Array<IntArray>): Int {
        val mtx = Array(n) { BooleanArray(n) }
        for (mine in mines) {
            mtx[mine[0]][mine[1]] = true
        }
        val saved = Array(n) { Array(n) { IntArray(4) } }
        var result = 0

        for (i in 0 until n) {
            for (j in 0 until n) {
                if (mtx[i][j]) {
                    saved[i][j][0] = 0
                } else {
                    result = 1
                    if (j == 0) {
                        saved[i][j][0] = 1
                    } else {
                        saved[i][j][0] = saved[i][j - 1][0] + 1
                    }
                }
            }
            for (j in n - 1 downTo 0) {
                if (mtx[i][j]) {
                    saved[i][j][1] = 0
                } else {
                    result = 1

                    if (j == n - 1) {
                        saved[i][j][1] = 1
                    } else {
                        saved[i][j][1] = saved[i][j + 1][1] + 1
                    }
                }
            }
        }

        for (j in 0 until n) {
            for (i in 0 until n) {
                if (mtx[i][j]) {
                    saved[i][j][2] = 0
                } else {
                    result = 1

                    if (i == 0) {
                        saved[i][j][2] = 1
                    } else {
                        saved[i][j][2] = saved[i - 1][j][2] + 1
                    }
                }
            }
            for (i in n - 1 downTo 0) {
                if (mtx[i][j]) {
                    saved[i][j][3] = 0
                } else {
                    result = 1

                    if (i == n - 1) {
                        saved[i][j][3] = 1
                    } else {
                        saved[i][j][3] = saved[i + 1][j][3] + 1
                    }
                }
            }
        }
        for (i in 1 until n - 1) {
            for (j in 1 until n - 1) {
                val tmp = minOf(minOf(saved[i][j][0], saved[i][j][1]), minOf(saved[i][j][2], saved[i][j][3]))
                result = maxOf(tmp, result)
            }
        }
        return result
    }
}

fun main() {
    val n = 1
    val s = "[[0,0]]"
    val mines = parserArrayIntArray(s)
    val result = OrderOfLargestPlusSign_764.orderOfLargestPlusSign(n, mines)
    result.printSelf()

}