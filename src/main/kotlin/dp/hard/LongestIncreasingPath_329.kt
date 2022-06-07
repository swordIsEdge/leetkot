package dp.hard

import java.util.*

object LongestIncreasingPath_329 {
    data class Node(
        val value: Int,
        val i: Int,
        val j: Int
    )

    fun longestIncreasingPath(matrix: Array<IntArray>): Int {
        val row = matrix.size
        if (row == 0) return 0
        val col = matrix[0].size
        val heap = PriorityQueue<Node>{n1,n2->n1.value.compareTo(n2.value)}
        for (i in 0 until row) {
            for (j in 0  until col) {
                heap.add(Node(matrix[i][j], i, j))
            }
        }
        val dp = Array(row) { IntArray(col) { 1 } }
        var max = 0
        while (heap.isNotEmpty()) {
            val (value, i, j) = heap.poll()
            if (i > 0 && matrix[i - 1][j] < matrix[i][j]) {
                dp[i][j] = maxOf(dp[i][j], dp[i - 1][j] + 1)
            }
            if (j > 0 && matrix[i][j - 1] < matrix[i][j]) {
                dp[i][j] = maxOf(dp[i][j], dp[i][j - 1] + 1)
            }
            if (i < row - 1 && matrix[i + 1][j] < matrix[i][j]) {
                dp[i][j] = maxOf(dp[i + 1][j] + 1, dp[i][j])
            }
            if (j < col - 1 && matrix[i][j + 1] < matrix[i][j]) {
                dp[i][j] = maxOf(dp[i][j], dp[i][j + 1] + 1)
            }
            max = maxOf(max,dp[i][j])

        }


        return max
    }
}