package middle

import java.util.*

object DailyTemperatures_739 {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val result = IntArray(temperatures.size)
        val stack = LinkedList<Int>()
        for ((i, v) in temperatures.withIndex()) {
            while (stack.isNotEmpty() && v > temperatures[stack.peek()]) {
                val lastIndex = stack.pop()
                result[lastIndex] = i - lastIndex
            }
            stack.push(i)
        }
        return result
    }
}

fun main() {
    val result = DailyTemperatures_739.dailyTemperatures(intArrayOf(73,74,75,71,69,72,76,73))
}