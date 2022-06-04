package easy

object Intersect_350 {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        if (nums1.isEmpty() || nums2.isEmpty()) return intArrayOf()
        if (nums1.size > nums2.size) return intersect(nums2, nums1)
        var i1 = 0
        var i2 = 0
        val result = mutableListOf<Int>()
        nums1.sort()
        nums2.sort()

        while (i1 < nums1.size  && i2 < nums2.size ) {
            val n1 = nums1[i1]
            val n2 = nums2[i2]
            if (n1 == n2) {
                i1++
                i2++
                result.add(n1)
            } else if (n1 < n2) {
                i1++
            } else {
                i2++
            }
        }
        return result.toIntArray()
    }
}

fun main() {
    val r = Intersect_350.intersect(intArrayOf(2, 2), intArrayOf(1, 2, 2, 1))
    println(r)

}