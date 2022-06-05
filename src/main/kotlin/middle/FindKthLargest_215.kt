package middle

import java.util.*

object FindKthLargest_215 {
    fun findKthLargest(nums: IntArray, k: Int): Int {

        val heap = PriorityQueue<Int>{i,j-> j - i}
        nums.forEach { heap.add(it) }
        for (i in 1 until k) {
            heap.poll()
        }
        return heap.peek()
    }

}