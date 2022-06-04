package medium

object FirstMissingPositive_41 {
    fun firstMissingPositive(nums: IntArray): Int {
        var minV = Int.MAX_VALUE
        nums.filter { it > 0 }.forEach { minV = minOf(it, minV) }
        if (minV > 1) return 1
        for (i in nums.indices) {
            var newV = nums[i]
            nums[i] = 0
            while (newV >= minV && newV-minV<nums.size ) {
                val next = nums[newV - minV]
                nums[newV - minV] = newV
                if (newV == next) {
                    break
                }
                newV = next
            }
        }
        for (i in nums.indices) {
            if (nums[i] == 0) {
                return minV + i
            }
        }
        return nums.size+1
    }
}

fun main() {
    val a = FirstMissingPositive_41.firstMissingPositive(intArrayOf(1,1))
    println(a)
}