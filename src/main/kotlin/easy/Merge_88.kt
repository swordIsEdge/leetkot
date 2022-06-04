package easy

object Merge_88 {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var i = m - 1
        var j = n - 1
        var k = m + n - 1
        while (i >= 0 || j >= 0) {
            val next = if (i < 0) {
                nums2[j--]
            } else if (j < 0) {
                nums1[i--]
            } else {
                val f = nums1[i]
                val s = nums2[j]
                if (f >= s) {
                    nums1[i--]
                } else {
                    nums2[j--]
                }
            }
            nums1[k--] = next
        }
    }
}

fun main() {
    Merge_88.merge(intArrayOf(0), 0, intArrayOf(1), 1)

}