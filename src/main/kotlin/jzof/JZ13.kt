package jzof

import java.util.*

object JZ13 {
    fun movingCount(threshold: Int, rows: Int, cols: Int): Int {
        // write code here
        val array = IntArray(maxOf(rows, cols)) { 0 }
        for (i in 1 until array.size) array[i] = if (i < 10) i else array[i / 10] + array[i % 10]
        val flags = Array(rows) { BooleanArray(cols) { false } }
        var total = 0
        val queue = LinkedList<Int>()
        queue.add(0)
        queue.add(0)
        flags[0][0] = true
        while (queue.isNotEmpty()) {
            val i = queue.poll()
            val j = queue.poll()
            if (array[i] + array[j] <= threshold) {
                println("$i,$j")
                total++
                if (i > 0 && !flags[i - 1][j]) {
                    queue.offer(i - 1)
                    queue.offer(j)
                    flags[i - 1][j] = true
                }
                if (j > 0 && !flags[i][j - 1]) {
                    queue.offer(i)
                    queue.offer(j - 1)
                    flags[i][j - 1] = true
                }
                if (i < rows - 1 && !flags[i + 1][j]) {
                    queue.offer(i + 1)
                    queue.offer(j)
                    flags[i+1][j] = true
                }
                if (j < cols - 1 && !flags[i][j + 1]) {
                    queue.offer(i)
                    queue.offer(j + 1)
                    flags[i][j+1] = true
                }
            }

        }
        return total
    }
}

fun main() {
    JZ13.movingCount(10, 1, 100)
}