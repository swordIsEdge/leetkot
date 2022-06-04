package easy

private class Solution {
    fun twoSumOld(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()

        for (i in nums.indices) {
            if (map.containsKey(target - nums[i])) {
                return intArrayOf(map[target - nums[i]] ?: 0, i)
            } else {
                map[nums[i]] = i
            }
        }
        return intArrayOf(0, 0)
    }

    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        for ((index, value) in nums.withIndex()) {
            if (map.containsKey(target - value)) {
                return intArrayOf(map[target - value]!!, index)
            }
            map[value] = index
        }
        return intArrayOf(0,0)
    }
}