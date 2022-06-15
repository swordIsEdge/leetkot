package dp.middle

import java.util.*

object UpdateMatrix_542 {
    data class Node(
        val i: Int,
        val j: Int,
        val dis: Int
    )

    fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
        val row = mat.size
        val col = mat[0].size
        val queue = LinkedList<Node>()
        val result = Array(row) { IntArray(col) }
        val visited = Array(row) { BooleanArray(col) }
        for (i in mat.indices) {
            for (j in 0 until col) {
                if (mat[i][j] == 0) {
                    visited[i][j] = true
                    queue.add(Node(i, j, 0))
                }
            }
        }
        while (queue.isNotEmpty()) {
            val (i, j, dis) = queue.poll()
            if (i > 0 && !visited[i - 1][j]) {
                visited[i - 1][j] = true
                result[i - 1][j] = dis + 1
                queue.add(Node(i - 1, j, dis + 1))
            }
            if (i < row - 1 && !visited[i + 1][j]) {
                visited[i + 1][j] = true
                result[i + 1][j] = dis + 1
                queue.add(Node(i + 1, j, dis + 1))
            }
            if (j > 0 && !visited[i][j - 1]) {
                visited[i][j - 1] = true
                result[i][j - 1] = dis + 1
                queue.add(Node(i, j - 1, dis + 1))
            }
            if (j < col - 1 && !visited[i][j + 1]) {
                visited[i][j + 1] = true
                result[i][j + 1] = dis + 1
                queue.add(Node(i, j + 1, dis + 1))
            }
        }
        return result
    }
}