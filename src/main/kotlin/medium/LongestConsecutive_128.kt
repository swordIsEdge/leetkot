package medium

object LongestConsecutive_128 {
    fun longestConsecutive(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        val map = hashMapOf<Int, Int>()
        var maxValue = 1
        for (num in nums) {
            if (num !in map.keys) {
                val left = map.getOrDefault(num - 1, 0)
                val right = map.getOrDefault(num + 1, 0)
                val len = left + right + 1
                map[num] = 0
                map[num - left] = len
                map[num + right] = len
                maxValue = maxOf(
                    maxValue, len
                )
            }
        }
        return maxValue
    }
}