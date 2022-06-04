package medium

object SpiralOrder_54 {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val h = matrix.size
        if (h == 0) return listOf()
        val w = matrix[0].size

        var up = 0
        var down = h - 1
        var left = 0
        var right = w - 1

        val result = mutableListOf<Int>()
        while (up <= down && left <= right) {
            for (j in left..right) {
                result.add(matrix[up][j])
            }
            for (i in up + 1 until down) {
                result.add(matrix[i][right])
            }
            if (up != down) {
                for (j in right downTo left) {
                    result.add(matrix[down][j])
                }
            }
            if (left != right) {
                for (i in down - 1 downTo up + 1) {
                    result.add(matrix[i][left])
                }
            }

            up++
            down--
            left++
            right--
        }
        return result
    }
}