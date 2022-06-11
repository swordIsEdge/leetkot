package dp.middle

object FindSquare_M_17_23 {
    fun findSquare(matrix: Array<IntArray>): IntArray {
        val n = matrix.size
        if (n == 0) return intArrayOf()
        val right = Array(n) { IntArray(n) }
        val down = Array(n) { IntArray(n) }
        (0 until n).forEach {
            right[it][n - 1] = if (matrix[it][n - 1] == 0) 1 else 0
            down[n - 1][it] = if (matrix[n - 1][it] == 0) 1 else 0
        }
        for (i in n - 1 downTo 0) {
            for (j in n - 2 downTo 0) {
                val cur = matrix[i][j]
                if (cur == 1) {
                    right[i][j] = 0
                } else {
                    right[i][j] = right[i][j + 1] + 1
                }
            }
        }
        for (i in n - 2 downTo 0) {
            for (j in n - 1 downTo 0) {
                val cur = matrix[i][j]
                if (cur == 1) {
                    down[i][j] = 0
                } else {
                    down[i][j] = down[i + 1][j] + 1
                }
            }
        }
        val result = intArrayOf(Int.MAX_VALUE, Int.MAX_VALUE, Int.MIN_VALUE)
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (matrix[i][j] == 1) {
                    continue
                }
                if (result[2] < 1) {
                    result[0] = i
                    result[1] = j
                    result[2] = 1
                }
                val maxLen = minOf(right[i][j], down[i][j])
                if (maxLen <= result[2]) {
                    continue
                }
                for (len in maxLen downTo 2) {
                    if (len <= result[2]) break
                    val rightIndex = j + len - 1
                    val downIndex = i + len - 1
                    if (down[i][rightIndex] >= len && right[downIndex][j] >= len) {
                        result[0] = i
                        result[1] = j
                        result[2] = len
                        break
                    }
                }
            }
        }
        return if (result[2] == Int.MIN_VALUE) intArrayOf() else result
    }
}

fun main() {
    FindSquare_M_17_23.findSquare(
        arrayOf(
            intArrayOf(1, 0, 1),
            intArrayOf(0, 0, 1),
            intArrayOf(0, 0, 1)
        )
    )
}