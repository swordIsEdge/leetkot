package middle

import common.printSelf

object FindPairs_532 {
    fun findPairs(nums: IntArray, k: Int): Int {
        if (nums.size < 2) return 0

        if (k == 0) {
            nums.sort()
            var lst = nums[0]
            var count = 0
            var index = 1
            while (index < nums.size) {
                if (nums[index] == lst) {
                    count++
                    while (index < nums.size && nums[index] == lst) index++
                } else {
                    lst= nums[index++]
                }
            }
            return count
        }


        val nums = nums.distinct().sorted()
        if (nums.size < 2) return 0
        var left = 0
        var right = 1
        var count = 0
        while (right < nums.size) {
            val diff = nums[right] - nums[left]
            if (diff == k) {
                count++
                right++
            } else if (diff < k) {
                right++
            } else {
                left++
            }
        }
        return count
    }
}

fun main() {
    FindPairs_532.findPairs(intArrayOf(3, 1, 4, 1, 4), 0).printSelf()

}