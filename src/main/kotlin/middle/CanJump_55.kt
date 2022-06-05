package middle

object CanJump_55 {
    fun canJump(nums: IntArray): Boolean {
        val tgt = nums.size - 1
        var max = 0
        for (index in nums.indices) {
            if (index>max) return false
            max = maxOf(max, index + nums[index] )
            if (max >= tgt) return true
        }
        return max >= tgt
    }
}