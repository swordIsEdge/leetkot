package middle

import java.util.PriorityQueue

object LargestNumber_179 {
    fun largestNumber(nums: IntArray): String {
        if (nums.isEmpty()) return ""
        if (nums.size == 1) return nums[0].toString()
        val heap = PriorityQueue<String> { s1, s2 -> (s2+s1).compareTo(s1+s2) }
        nums.map { it.toString() }.forEach { heap.add(it) }
        val sb = StringBuilder()
        while (heap.isNotEmpty()) {
            val next = heap.poll()
            if (next == "0") {
                if (sb.isNotEmpty() || heap.isEmpty()) {
                    sb.append(next)
                }
            } else {
                sb.append(next)
            }
        }
        return sb.toString()
    }
}

fun main() {
    print(
        LargestNumber_179.largestNumber(
            intArrayOf(3, 30, 34, 5, 9)
        )
    )
}