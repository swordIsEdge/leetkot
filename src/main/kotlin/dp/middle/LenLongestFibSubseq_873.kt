package dp.middle

object LenLongestFibSubseq_873 {
    fun lenLongestFibSubseq(arr: IntArray): Int {
        val len = arr.size
        var max = 0
        val dp = Array(len) { IntArray(len) { 2 } }
        for (i in 2 until len) {
            val cur = arr[i]
            var left = 0
            var right = i - 1
            while (left < right) {
                val tmpSum = arr[left] + arr[right]
                if (tmpSum == cur) {
                    dp[right][i] = dp[left][right] + 1
                    max = maxOf(max, dp[right][i])
                    left++
                    right--
                } else if (tmpSum < cur) {
                    left++
                } else {
                    right--
                }
            }
        }
        return if (max>2) max else 0

    }
}