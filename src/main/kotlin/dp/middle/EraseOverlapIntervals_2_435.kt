package dp.middle

import common.printSelf
import java.util.*

object EraseOverlapIntervals_2_435 {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        Arrays.sort(intervals) { f, s -> f[0].compareTo(s[0]) }
        var last = intervals[0]
        var count = 0
        for (i in 1 until intervals.size) {
            val cur = intervals[i]
            if (cur[0] == last[0]) {
                last[1] = minOf(last[1], cur[1])
                count++
            } else if (cur[0] < last[1]) {
                count++
                if (cur[1] < last[1]) {
                    last = cur
                }

            } else {
                last = cur
            }
        }
        return count
    }
}

fun main() {
    EraseOverlapIntervals_2_435.eraseOverlapIntervals(
        arrayOf(
            intArrayOf(1, 100),
            intArrayOf(1, 11),
            intArrayOf(2, 12),
            intArrayOf(11, 22)
        )
    ).printSelf()
}