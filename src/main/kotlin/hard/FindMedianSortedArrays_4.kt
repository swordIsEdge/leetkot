package hard

object FindMedianSortedArrays_4 {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        if (nums1.size > nums2.size) return findMedianSortedArrays(nums2, nums1)
        val len1 = nums1.size
        val len2 = nums2.size

        var left = 0
        var right = len1
        val indexSum = (len1 + len2 + 1) shr 1

        while (left < right) {
            val mid = (left + right) shr 1
            val otherIndex = indexSum - mid

            val value1 = nums1[mid]
            val value2 = nums2[otherIndex - 1]
            if (value1 <= value2) {
                left = mid + 1
            } else {
                right = mid
            }
        }
        val maxLeft = maxOf(
            if (left <= 0) Int.MIN_VALUE else nums1[left - 1],
            if (indexSum == left) Int.MIN_VALUE else nums2[indexSum - left - 1]
        )
        val minRight = minOf(
            if (left == len1) Int.MAX_VALUE else nums1[left],
            if (indexSum - left >= len2) Int.MAX_VALUE else nums2[indexSum - left]
        )
        return if ((len1 + len2) % 2 == 1) maxLeft * 1.0 else (maxLeft + minRight) / 2.0
    }
}

fun main() {
    val r = FindMedianSortedArrays_4.findMedianSortedArrays(
        intArrayOf(1, 2),
        intArrayOf(3, 4)
    )
    println(r)
}