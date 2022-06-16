package hard

import java.util.*

object SmallestDistancePair_719 {

    fun smallestDistancePair(nums: IntArray, k: Int): Int {
        Arrays.sort(nums)
        val len = nums.size
        var start = -1
        var end = nums[len - 1]-nums[0]+1
//        while (start < end) {
//            val mid = start + ((end - start) shr 1)
//            val littleThanMid = getLittelThanMid(nums, mid)
//            if (littleThanMid >= k) {
//                end = mid
//            } else {
//                start = mid + 1
//            }
//        }
        while (start+1 < end) {
            val mid = start + ((end - start) shr 1)
            val littleThanMid = getLittelThanMid(nums, mid)
            if (littleThanMid >= k) {
                end = mid
            } else {
                start = mid
            }
        }

        return end
    }
    fun getLittelThanMid(nums: IntArray, mid: Int): Int {
        var result = 0
        var i = 0
        var j = 0
        while (i < nums.size) {
            while (nums[i] - nums[j] > mid) j++
            result += (i - j)
            i++
        }
        return result
    }
}