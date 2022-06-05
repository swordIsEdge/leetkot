package middle

object SearchRange_34 {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        if (nums.isEmpty()) return intArrayOf(-1, -1)
        if (target < nums[0] || target > nums[nums.size - 1]) {
            return intArrayOf(-1, -1)
        }

        return binarySearch(nums, target)

    }

    fun binarySearch(nums: IntArray, target: Int): IntArray {
        val result = IntArray(2) { -1 }
        if (nums[0] == target) {
            result[0] = 0
        } else {
            var i = 0
            var j = nums.size - 1
            while (i <= j) {
                val mediumIndex = (i + j) / 2
                val medium = nums[mediumIndex]
                if (medium >= target) {
                    j = mediumIndex - 1
                } else {
                    val next = nums[mediumIndex + 1]
                    if (next == target) {
                        result[0] = mediumIndex + 1
                        break
                    } else if (next < target) {
                        i = mediumIndex + 1
                    } else {
                        return intArrayOf(-1, -1)
                    }
                }
            }
        }

        if (nums[nums.size - 1] == target) {
            result[1] = nums.size - 1
        } else {
            var i = 0
            var j = nums.size - 1
            while (i <= j) {
                val mediumIndex = (i + j) / 2
                val medium = nums[mediumIndex]
                if (medium <= target) {
                    i = mediumIndex + 1
                } else {
                    val last = nums[mediumIndex - 1]
                    if (last == target) {
                        result[1] = mediumIndex - 1
                        break
                    } else if (last > target) {
                        j = mediumIndex - 1
                    } else {
                        return intArrayOf(-1, -1)
                    }
                }
            }
        }
        return result
    }
}

fun main() {
    val result = SearchRange_34.searchRange(intArrayOf(6), 6)
    println("${result[0]},${result[1]}")
}