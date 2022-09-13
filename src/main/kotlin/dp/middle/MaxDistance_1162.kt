package dp.middle

import common.parserArrayIntArray
import common.printSelf
import java.util.LinkedList

data class Point(
    val i: Int,
    val j: Int,
    val distance: Int
)

object MaxDistance_1162 {


    fun maxDistance(grid: Array<IntArray>): Int {
        var queue = LinkedList<Point>()
        var next = LinkedList<Point>()

        val row = grid.size
        val col = grid[0].size
        val total = row * col
        var tmp = 0
        val dp = Array(row) { BooleanArray(col) { false } }
        for (i in 0 until row) {
//            grid[i].printSelf()
            for (j in 0 until col) {
                if (grid[i][j] == 1) {
                    dp[i][j] = true
                    queue.add(Point(i, j, 0))
                    tmp++
                }
            }
        }
        if (tmp == 0 || tmp == total) return -1

        var distance = 1
         while (true) {
            while (queue.isNotEmpty()) {
                val node = queue.poll()
                val i = node.i
                val j = node.j
                val dis = node.distance
                if (i > 0 && !dp[i - 1][j]) {
                    dp[i - 1][j] = true
                    tmp++
                    next.add(Point(i - 1, j, dis + 1))
                }
                if (tmp == total) return dis + 1
                if (j > 0 && !dp[i][j - 1]) {
                    dp[i][j - 1] = true
                    tmp++
                    next.add(Point(i, j - 1, dis + 1))
                }
                if (tmp == total) return dis + 1
                if (i < row - 1 && !dp[i + 1][j]) {
                    dp[i + 1][j] = true
                    tmp++
                    next.add(Point(i + 1, j, dis + 1))
                }
                if (tmp == total) return dis + 1
                if (j < col - 1 && !dp[i][j + 1]) {
                    dp[i][j + 1] = true
                    tmp++
                    next.add(Point(i, j + 1, dis + 1))

                }
                if (tmp == total) return dis + 1
            }
            queue = next
            next = LinkedList()
            distance++
        }
    }
}

fun main() {
    val s =
        " [[1,0,1],[0,0,0],[1,0,1]]"
    val aia = parserArrayIntArray(s)
    val res = MaxDistance_1162.maxDistance(aia)
    res.printSelf()
}