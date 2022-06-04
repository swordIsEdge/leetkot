package jzof

object JZ59 {
    fun maxInWindows(num: IntArray, size: Int): IntArray {
        // write code here
        val res = IntArray(num.size - size + 1)
        val q = mutableListOf<Int>()
        for ((index, value) in num.withIndex()) {
            while (q.isNotEmpty() && num[q.last()] < value) {
                q.removeLast()
            }
            q.add(index)
            if (q.first() <index-size+1) {
                q.removeFirst()
            }
            if (index >= size-1) {
                res[index-size+1] = num[q.first()]
            }
        }
        return res
    }
}

fun main() {
    val result = JZ59.maxInWindows(intArrayOf(2, 3, 4, 2, 6, 2, 5, 1), 3)
    println(result)
}