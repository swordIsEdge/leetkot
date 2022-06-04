package easy

object FindDisappearedNumbers_448 {
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        if (nums.isEmpty()) {
            return listOf()
        }
        val result = mutableListOf<Int>()
        for (i in nums.indices) {
            var j = i
            var value = nums[j]
            while (j + 1 != value) {
                val tmp = nums[value - 1]
                nums[value - 1] = value
                j = value - 1
                value = tmp
            }
        }

        for ((i, v) in nums.withIndex()) {
            if (v != i + 1) {
                result.add(i + 1)
            }
        }
        return result
    }

}