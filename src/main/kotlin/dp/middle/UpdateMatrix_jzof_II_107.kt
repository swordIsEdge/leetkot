package dp.middle

import java.util.LinkedList

object UpdateMatrix_jzof_II_107 {
    data class Node(
        val i: Int,
        val j: Int,
        val dis: Int
    )

    fun updateMatrix(mat: Array<IntArray>): Array<IntArray> {
        val row = mat.size
        val col = mat[0].size
        val result = Array(row) { IntArray(col) { -1 } }
        val queue = LinkedList<Node>()
        for (i in 0 until row) {
            for (j in 0 until col) {
                if (mat[i][j] == 0) {
                    result[i][j] = 0
                    queue.add(Node(i, j, 0))
                }
            }
        }
        while (queue.isNotEmpty()) {
            val node = queue.poll()
            if (node.i > 0) {
                if (result[node.i - 1][node.j] < 0) {result[node.i - 1][node.j] = node.dis + 1
                queue.add(Node(node.i - 1, node.j, node.dis + 1))}
            }
            if (node.j > 0) {
                if (result[node.i][node.j - 1] < 0) {result[node.i][node.j - 1] = node.dis + 1
                queue.add(Node(node.i, node.j - 1, node.dis + 1))}
            }
            if (node.i < row - 1) {
                if (result[node.i + 1][node.j] < 0) {result[node.i + 1][node.j] = node.dis + 1
                queue.add(Node(node.i + 1, node.j, node.dis + 1))}
            }
            if (node.j < col - 1) {
                if (result[node.i][node.j + 1] < 0) {result[node.i][node.j + 1] = node.dis + 1
                queue.add(Node(node.i, node.j + 1, node.dis + 1))}
            }
        }
        return result
    }
}