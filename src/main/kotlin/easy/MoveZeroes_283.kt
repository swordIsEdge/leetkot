package easy

object MoveZeroes_283 {
    fun moveZeroes(nums: IntArray): Unit {
        if (nums.isEmpty()) return
        var count = 0
        var nzIdnex = 0
        for (i in nums.indices) {
            val value = nums[i]
            if (value != 0) {
                nums[nzIdnex++] = value
            } else
                count++
        }
        for (i in (nums.size - count) until nums.size) {
            nums[i] = 0
        }
    }
}
