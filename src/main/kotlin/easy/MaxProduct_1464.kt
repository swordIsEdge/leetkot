package easy

object MaxProduct_1464 {
    fun maxProduct(nums: IntArray): Int {
        val len = nums.size
        if (len == 2) {
            return (nums[0] - 1) * (nums[1] - 1)
        } else {
            var first = minOf(nums[0], nums[1])
            var second = maxOf(nums[0], nums[1])
            for (i in 2 until len) {
                val cur = nums[i]
                if (cur > first) {
                    first = cur
                    if (first > second) {
                        first = second.apply { second = first }
                    }
                }
            }


            return (first - 1) * (second - 1)
        }
    }
}