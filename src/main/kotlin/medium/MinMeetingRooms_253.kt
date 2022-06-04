package medium

import java.util.*

object MinMeetingRooms_253 {
    fun minMeetingRooms(intervals: Array<IntArray>): Int {
        val heap = PriorityQueue<Int>()
        intervals.sortBy { it[0] }
        for (interval in intervals) {
            val start = interval[0]
            val end = interval[1]
            if (heap.isNotEmpty() && heap.peek() <= start) {
                heap.poll()
            }
            heap.add(end)
        }
        return heap.size
    }
}