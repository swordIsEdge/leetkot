package dp.middle

import common.parserArrayIntArray
import common.printSelf

object MinFallingPathSum_931 {
    fun minFallingPathSum(matrix: Array<IntArray>): Int {
        val len = matrix.size
        if (len == 1) return matrix[0][0]

        for (i in len - 1 downTo 1) {
            for (j in 0 until len) {
                if (j == 0) {
                    matrix[i - 1][j] += minOf(matrix[i][j + 1], matrix[i][j])
                } else if (j == len - 1) {
                    matrix[i - 1][j] += minOf(matrix[i][j - 1], matrix[i][j])
                } else {
                    matrix[i - 1][j] += minOf(minOf(matrix[i][j - 1], matrix[i][j + 1]), matrix[i][j])
                }
            }
        }
        var result = matrix[0][0]
        for (i in matrix[0]) {
            result = minOf(result, i)
        }
        return result
    }
}

fun main() {
    val s = " [[-19,57],[-40,-5]]"
    val mtx = parserArrayIntArray(s)
    val result = MinFallingPathSum_931.minFallingPathSum(mtx)
    result.printSelf()
}