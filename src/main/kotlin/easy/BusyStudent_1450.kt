package easy

object BusyStudent_1450 {
    fun busyStudent(startTime: IntArray, endTime: IntArray, queryTime: Int): Int {
        val len = startTime.size
        var result = 0
        for (i in 0 until len) {
            if (startTime[i]<=queryTime && endTime[i]>=queryTime) result++
        }
        return result
    }
}