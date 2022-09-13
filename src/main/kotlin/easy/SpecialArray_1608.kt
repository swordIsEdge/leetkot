package easy

object SpecialArray_1608 {
    fun specialArray(nums: IntArray): Int {
        val counter = IntArray(1001)
        nums.forEach { counter[it]++ }
        var tmp = 0

        for (i in 1000 downTo 0) {
            tmp += counter[i]
            if (tmp == i) {
                return tmp

            }
        }
        return -1
    }
}