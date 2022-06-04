package jzof

object JZ29 {
    fun printMatrix(matrix: Array<IntArray>): IntArray {
        // write code here
        val h = matrix.size
        val w = matrix[0].size
        val result = IntArray(h * w)
        val circle = minOf((h + 1) shr 1, (w + 1) shr 1)
        var ai = 0
        for (index in 0 until circle) {
            val left = index
            val right = w - index-1
            val up = index
            val down = h - index-1

            for (i in left..right) {
                result[ai++] = matrix[up][i]
            }
            for (j in up + 1 until down) {
                result[ai++] = matrix[j][right]
            }
            if (up + 1 <= down) {
                for (i in right downTo left) {
                    result[ai++] = matrix[down][i]
                }
            }
            if (left + 1 <= right) {
                for (j in down - 1 downTo up + 1) {
                    result[ai++] = matrix[j][left]
                }
            }


        }
        return result
    }
}

fun main() {
    val matrix = arrayOf(intArrayOf(1,2,3,4), intArrayOf(5,6,7,8), intArrayOf(9,10,11,12), intArrayOf(13,14,15,16))
    val result = JZ29.printMatrix(matrix)
    for (i in result) {
        print("$i,")
    }

}