package medium

object ThreeSum_15 {
    fun threeSum(nums: IntArray): List<List<Int>> {
        if (nums.size < 3) return listOf()
        nums.sort()
        val result = mutableListOf<List<Int>>()
        for (i in 0..(nums.size - 3)) {
            if (i > 0 && nums[i] == nums[i - 1]) continue
            var k = nums.size - 1
            for (j in i + 1..nums.size - 2) {
                if (j >= k) break
                if (j > i + 1 && nums[j] == nums[j - 1]) continue
                while (nums[i] + nums[j] + nums[k]>0 && j<k){k--}
                if (j >= k) break
                if (nums[i] + nums[j] + nums[k] == 0) result.add(listOf(nums[i], nums[j], nums[k]))

            }

        }
        return result
    }
}

fun main() {
    val result = ThreeSum_15.threeSum(intArrayOf(-1, 0, 1, 2, -1, -4))
    for (ints in result) {
        for (int in ints) {
            print("$int->")
        }
        println()
    }
}