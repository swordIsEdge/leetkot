package hard

import java.util.*

object MaximalRectangle_85 {
    fun maximalRectangle(matrix: Array<CharArray>): Int {
        val h = matrix.size
        val w = matrix[0].size
        val dp1 = Array(h) { IntArray(w) { 0 } }

        for (i in 0 until h) {
            for (j in 0 until w) {
                dp1[i][j] = if (i == 0) {
                    if (matrix[i][j] == '1') 1 else 0
                } else {
                    if (matrix[i][j] == '1') dp1[i - 1][j] + 1 else 0
                }
            }
        }

        var max = 0

        for (i in 0 until h) {
            val tmp = intArrayOf(0) + dp1[i] + 0
            val dp = IntArray(2 + w) { 0 }
            val stack = LinkedList<Int>()
            for (index in dp.indices) {
                val cur = tmp[index]
                while (stack.isNotEmpty() && tmp[stack.peek()] > cur) {
                    val height = tmp[stack.pop()]
                    val area = height*(index-stack.peek()-1)
                    max = maxOf(max, area)
                }
                stack.push(index)
            }
        }
        return max
    }
}

fun main() {

}