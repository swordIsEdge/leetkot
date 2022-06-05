package dp.middle

object Jump_II_45 {
    fun jump(nums: IntArray): Int {
        var end = 0
        var maxPostion = 0
        val len = nums.size

        var step = 0

        for (i in 0 until len - 1) {
            maxPostion = maxOf(maxPostion, i + nums[i])
            if (i == end) {
                end = maxPostion
                step++
            }
        }
        return step
    }
}