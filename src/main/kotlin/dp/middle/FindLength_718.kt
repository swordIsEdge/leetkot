package dp.middle

object FindLength_718 {
    fun findLength(nums1: IntArray, nums2: IntArray): Int {
        val len1 = nums1.size
        val len2 = nums2.size
        val dp = Array(len1) { IntArray(len2) }
        var max = 0
        (0 until len2).forEach { dp[0][it] = if (nums2[it] == nums1[0]) 1 else 0;max = maxOf(max,dp[0][it]) }

        for (i in 1 until len1) {
            dp[i][0] = if (nums2[0] == nums1[i]) 1 else 0
            max = maxOf(max,dp[i][0])
            for (j in 1 until len2) {
                dp[i][j] = if (nums1[i] == nums2[j]) {
                    dp[i - 1][j - 1] + 1
                } else 0
                max = maxOf(max,dp[i][j])
            }
        }
        return max

    }
}