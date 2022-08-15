package dp.middle

import common.parserArrayIntArray
import common.printSelf

object FindBall_1706 {
    fun findBall(grid: Array<IntArray>): IntArray {
        val row = grid.size
        val col = grid[0].size
        val indexs = IntArray(col) { it }
        for (i in 0 until row) {
            for (j in indexs.indices) {
                val index = indexs[j]
                if (index >= 0) {
                    val left = if (index == 0) 0 else grid[i][index - 1]
                    val right = if (index + 1 == col) 0 else grid[i][index + 1]
                    indexs[j] = next(grid[i][index], col, index, left, right)
                }
            }
        }
        return indexs
    }

    fun next(value: Int, col: Int, i: Int, left: Int, right: Int): Int {
        return if (value == 1) {
            if (i == col - 1) {
                -1
            } else if (right == 1) {
                i + 1
            } else {
                -1
            }
        } else {
            if (i == 0) {
                -1
            } else if (left == 1) {
                -1
            } else {
                i - 1
            }
        }
    }
}

fun main() {
    val grid = parserArrayIntArray("[[-1]]")
    val result = FindBall_1706.findBall(grid)
    result.printSelf()
}
