package medium

object FindUnsortedSubarray_581 {
    fun findUnsortedSubarray0(nums: IntArray): Int {
        val sorted = nums.sorted()
        var start = -1
        var end = nums.size

        for (s in 0 until nums.size) {
            if (nums[s] != sorted[s]) {
                start = s
                break
            }
        }
        for (e in nums.size - 1 downTo 0) {
            if (nums[e] != sorted[e]) {
                end = e
                break
            }
        }
        if (start == -1 || end == nums.size) {
            return 0
        }
        return end - start + 1
    }

    fun findUnsortedSubarray(nums: IntArray): Int {
        if (nums.size <= 1) {
            return 0
        }

        var minIndex = -1
        for (i in 1 until nums.size) {
            if (minIndex < 0) {
                if (nums[i] < nums[i - 1]) {
                    minIndex = i
                }
            } else {
                if (nums[i] < nums[minIndex]) {
                    minIndex = i
                }
            }
        }
        if (minIndex < 0) {
            return 0
        }
        val start = nums[minIndex]

        var maxIndex = nums.size
        for (i in nums.size - 2 downTo 0) {
            if (maxIndex == nums.size) {
                if (nums[i] > nums[i + 1]) {
                    maxIndex = i
                }
            } else {
                if (nums[i] > nums[maxIndex]) {
                    maxIndex = i
                }
            }
        }
        val end = nums[maxIndex]
        // 计算第一个比 start 大的作为开始
        // 计算最后一个比end小的作为结束
        var startIndex = -1
        var endIndex = 0
        for (index in nums.indices) {
            if (startIndex < 0 && nums[index] > start) {
                startIndex = index
            }
            if (nums[index] < end) {
                endIndex = index
            }
        }
        return endIndex - startIndex+1
    }
}