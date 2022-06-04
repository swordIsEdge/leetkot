package medium

object SearchMatrix_240 {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        if (matrix.isEmpty()) return false
        val h = matrix.size
        val w = matrix[0].size
        var i = 0
        var j = w - 1
        while (i < h && j >= 0) {
            val value = matrix[i][j]
            if (value == target) {
                return true
            }
            if (value < target) {
                i++
            } else {
                j--
            }
        }
        return false
    }
}

fun main() {
    val result = SearchMatrix_240.searchMatrix(
        arrayOf(
//            intArrayOf(1, 4, 7, 11, 15),
//            intArrayOf(2, 5, 8, 12, 19),
//            intArrayOf(3, 6, 9, 16, 22),
//            intArrayOf(13, 14, 17, 24),
//            intArrayOf(21, 23, 26, 30)
            intArrayOf(5)
        ),
        5
    )
}