package medium

object Rotate_48 {
    fun rotate(matrix: Array<IntArray>): Unit {
        val n = matrix.size
        if (n <= 1) {
            return
        }
        val endIndex = (n - 1) shr 1
        val endIndex2 = (n - 2) shr 1
        for (i in 0..endIndex) {
            for (j in 0..endIndex2) {
                val tmp = matrix[i][j]
                matrix[i][j] = matrix[n - 1 - j][i]
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j]
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i]
                matrix[j][n - 1 - i] = tmp
            }
        }
    }
}