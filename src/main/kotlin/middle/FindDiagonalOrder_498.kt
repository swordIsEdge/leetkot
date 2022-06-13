package middle

object FindDiagonalOrder_498 {
    fun findDiagonalOrder(mat: Array<IntArray>): IntArray {
        val m = mat.size
        val n = mat[0].size
        val result = mutableListOf<Int>()
        var vol = false

        for (i in 0 until m+n-1) {
            if (vol) {
                for (j in i downTo 0) {
                    if (i - j < m && j < n) result.add(mat[i - j][j])
                }
            } else {
                for (j in i downTo 0) {
                    if (j < m && i - j < n) result.add(mat[j][i - j])
                }
            }

            vol = !vol

        }
        return result.toIntArray()
    }
}