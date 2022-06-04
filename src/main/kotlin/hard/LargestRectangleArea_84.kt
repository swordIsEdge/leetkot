package hard

import java.util.*

object LargestRectangleArea_84 {
    fun largestRectangleArea(heights: IntArray): Int {
        var max = 0

        val stack = LinkedList<Int>()
        for (index in heights.indices) {
            max = maxOf(heights[index], max)
            if (stack.isEmpty()) {
                stack.push(index)
            } else {
                if (heights[stack.peek()] <= heights[index]) {
                    stack.push(index)
                } else {
                    val maxIndex = stack.peek()
                    while (stack.isNotEmpty() && heights[stack.peek()] > heights[index]) {
                        val minValue = heights[stack.pop()]
                        val lastIndex = if (stack.isEmpty()) -1 else stack.peek()
                        max = maxOf(max, (maxIndex - lastIndex) * minValue)
                    }
                    val lastIndex = if (stack.isEmpty()) -1 else stack.peek()
                    max = maxOf(max, (index - lastIndex) * heights[index])

                    stack.push(index)
                }
            }
        }
        if (stack.isNotEmpty()) {
            val maxIndex = stack.pop()
            while (stack.isNotEmpty()) {
                val minValue = heights[stack.pop()]
                val lastIndex = if (stack.isEmpty()) -1 else stack.peek()
                max = maxOf(max, (maxIndex - lastIndex) * minValue)
            }
        }
        return max
    }

    fun largestRectangleArea2(heights: IntArray): Int {
        val newH = intArrayOf(0) + heights + 0
        var result = 0
        val stack = LinkedList<Int>()
        for (i in newH.indices) {
            while (stack.isNotEmpty() && newH[stack.peek()] > newH[i]) {
                val value = newH[stack.pop()]
                val leftMinIndex = stack.peek()
                result = maxOf(result, (i - leftMinIndex - 1)*value)

            }
            stack.push(i)
        }
        return result
    }
}

fun main() {
    val res = LargestRectangleArea_84.largestRectangleArea2(intArrayOf(5, 5, 1, 7, 1, 1, 5, 2, 7, 6))
    println(res)
}