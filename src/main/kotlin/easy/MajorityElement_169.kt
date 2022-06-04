package easy

object MajorityElement_169 {
    fun majorityElement(nums: IntArray): Int {
        var num = nums[0]
        var count = 1
        for (i in 1 until nums.size) {
            if (count == 0) {
                num = nums[i]
                count++
            }else if (num == nums[i]) {
                count++
            } else {
                count--
            }
        }
        return num
    }
}