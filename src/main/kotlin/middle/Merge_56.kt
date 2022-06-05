package middle

object Merge_56 {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        if (intervals.size <= 1) return intervals
        val result = mutableListOf<IntArray>()
        intervals.sortBy { it[0] }
        var start = intervals[0][0]
        var end = intervals[0][1]
        for (i in 1 until intervals.size) {
            val tmpStart = intervals[i][0]
            val tmpEnd = intervals[i][1]
            if (end >= tmpStart) {
                end = maxOf(end, tmpEnd)
            } else {
                result.add(intArrayOf(start, end))
                start = tmpStart
                end = tmpEnd
            }
        }
        result.add(intArrayOf(start, end))

        return result.toTypedArray()
    }
}