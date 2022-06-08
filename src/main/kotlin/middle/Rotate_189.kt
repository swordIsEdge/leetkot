package middle

object Rotate_189 {
    fun rotate(nums: IntArray, k: Int): Unit {
        if (k == 0 || nums.isEmpty() || nums.size == 1) return
        val nk = k % nums.size
        if (nk == 0) return

        for (d in 1..nk) {
            val l = nums[nums.size-1]
            for (i in nums.size - 2 downTo 0) {
                nums[i + 1] = nums[i]
            }
            nums[0] = l
        }
    }

}