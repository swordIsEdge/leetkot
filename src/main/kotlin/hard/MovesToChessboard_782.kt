package hard

import common.parserArrayIntArray

object MovesToChessboard_782 {
    fun movesToChessboard(board: Array<IntArray>): Int {
        val n = board.size
        val oneCounts = IntArray(n)
        for ((index, bd) in board.withIndex()) {
            oneCounts[index] = bd.sumOf { it }
        }
        val onesVertical = IntArray(n)
        for (index in 0 until n) {
            for (subIndex in 0 until n) {
                onesVertical[subIndex] += board[index][subIndex]
            }
        }
        if (n % 2 == 0) {
            if (oneCounts.any { it != n shr 1 }) {
                return -1
            }
            if (onesVertical.any { it != n shr 1 })
                return -1
        } else {
            if (oneCounts.any { it != n shr 1 && it != (n shr 1) + 1 }) return -1
            if (onesVertical.any { it != n shr 1 && it != (n shr 1) + 1 }) return -1
        }


        return n
    }
}

fun main() {
    val board1 = parserArrayIntArray("[[0,1,1,0],[0,1,1,0],[1,0,0,1],[1,0,0,1]]")
    val board2 = parserArrayIntArray("[[0, 1], [1, 0]]")
    val board3 = parserArrayIntArray(" [[1, 0], [1, 0]]")
}