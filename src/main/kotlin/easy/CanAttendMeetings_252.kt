package easy

object CanAttendMeetings_252 {
    fun canAttendMeetings(intervals: Array<IntArray>): Boolean {
        if (intervals.size < 2) return true
        intervals.sortBy { it[0] }
        var end = intervals[0][0] - 1
        for (interval in intervals) {
            val start = interval[0]
            if (start < end) {
                return false
            }
            end = interval[1]
        }
        return true

    }
}