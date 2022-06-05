package middle

import kotlin.math.abs

object ThreeSumClosest_16 {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()
        var closed = Int.MAX_VALUE
        var minDis = Int.MAX_VALUE

        for (i in 0..nums.size - 3) {
            var left = i + 1
            var right = nums.size - 1
            val tmpTgt = target - nums[i]
            while (left < right) {
                val sum = nums[left] + nums[right] + nums[i]
                val dis = abs(sum - target)
                if (dis < minDis) {
                    minDis = dis
                    closed = sum
                    if (sum == target) {
                        return sum
                    }
                }
                val tmpSum = nums[left] + nums[right]
                if (tmpSum < tmpTgt) {
                    left++
                } else if (tmpSum > tmpTgt) {
                    right--
                } else {
                    return target
                }
            }
        }
        return closed
    }
}

fun main() {
    ThreeSumClosest_16.threeSumClosest(intArrayOf(-1,2,1,-4),1)
}