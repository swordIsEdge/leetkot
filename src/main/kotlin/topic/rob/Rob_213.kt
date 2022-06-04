package topic.rob

object Rob_213 {
    fun rob(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        if (nums.size <= 3) {
            var max = nums[0]
            nums.forEach { max = maxOf(max, it) }
            return max
        }

        val dpWith1 = IntArray(nums.size) { 0 }
        val dpWithout1 = IntArray(nums.size) { 0 }

        dpWith1[0] = nums[0]
        dpWith1[1] = maxOf(nums[0], nums[1])
        dpWithout1[0] = 0
        dpWithout1[1] = nums[1]

        for (i in 2 until nums.size - 1) {
            dpWith1[i] = maxOf(dpWith1[i - 1], dpWith1[i - 2] + nums[i])
            dpWithout1[i] = maxOf(dpWithout1[i - 1], dpWithout1[i - 2] + nums[i])
        }
        val lastIndex = nums.size - 1
        dpWith1[lastIndex] = maxOf(dpWith1[lastIndex - 1], dpWith1[lastIndex - 2])
        dpWithout1[nums.size - 1] = maxOf(dpWithout1[lastIndex - 1], dpWithout1[lastIndex - 2] + nums[lastIndex])
        return maxOf(dpWith1[lastIndex], dpWithout1[lastIndex])
    }
}

fun main() {
    val result = Rob_213.rob(intArrayOf(1, 2, 3, 1))
    println(result)
}