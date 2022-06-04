package easy

object RemoveDuplicates_26 {
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.size <= 1) return nums.size
        var l = 0
        var r = 1

        while (r < nums.size) {
            if (nums[l] != nums[r]) {
                nums[++l] = nums[r]
            }
            r++
        }
        return l + 1
    }
}