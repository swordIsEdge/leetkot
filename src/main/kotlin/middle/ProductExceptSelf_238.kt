package middle

object ProductExceptSelf_238 {
    fun productExceptSelf(nums: IntArray): IntArray {
        if (nums.size <=1) return nums
        val left = IntArray(nums.size) { 1 }
        val right = IntArray(nums.size) { 1 }
        for (i in 1 until nums.size) {
            left[i] = left[i - 1] * nums[i-1]
        }
        for (i in (nums.size - 2) downTo 0) {
            right[i] = right[i + 1] * nums[i+1]
        }
        return (nums.indices).map { it -> left[it] * right[it] }.toTypedArray().toIntArray()
    }
}