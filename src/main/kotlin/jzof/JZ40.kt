package jzof

import java.util.PriorityQueue

object JZ40 {
    fun GetLeastNumbers_Solution(input: IntArray, k: Int): IntArray {
        // write code here
        if (k == 0) {
            return IntArray(0)
        }
        val result = IntArray(k)
        val heap = PriorityQueue<Int>(k) { x, y -> x - y }
        input.forEach { heap.add(it) }
        for (i in 0 until k) {
            result[i] = heap.poll()
        }
        return result
    }
}

fun main() {
    val res = JZ40.GetLeastNumbers_Solution(intArrayOf(4,5,1,6,2,7,3,8),4)
    for (re in res) {
        print("$re->")
    }

}