package dp.middle

import java.util.*

object EraseOverlapIntervals_435 {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        Arrays.sort(intervals){f,s->if (f[0]==s[0])f[1]-s[1] else f[0] - s[0]}
        var count = 0
        var lstEnd = intervals[0][1]
        for (i in 1 until intervals.size) {
            if (intervals[i][1] <= lstEnd) {
                lstEnd = intervals[i][1]
                println("replace end as $lstEnd  cur [${intervals[i][0]},${intervals[i][1]}]")
                count++
            }else if (intervals[i][0] < lstEnd) {
                println("cur [${intervals[i][0]},${intervals[i][1]}]")
                count++
            } else {
                lstEnd = intervals[i][1]
            }
        }
        return count
    }
}

fun main() {
    println(
        EraseOverlapIntervals_435.eraseOverlapIntervals(
            arrayOf(
                intArrayOf(1,2),
                intArrayOf(2,3),
                intArrayOf(3,4),
                intArrayOf(1,3)
//                intArrayOf(4,6)
            )
        )
    )
}