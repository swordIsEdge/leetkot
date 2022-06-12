package dp.middle

object LenLongestFibSubseq_jzof_II_093 {
    fun lenLongestFibSubseq(arr: IntArray): Int {
        if (arr.size < 3) return 0
        val deMap = arr.withIndex().associate { (i, v) -> v to i }
        val len = arr.size
        val dp = Array(len) { IntArray(len) { 2 } }
        val maxValue = arr.max()
        var max = 0

        for (i in 0 until len) {
            val f = arr[i]
            for (j in i + 1 until len) {
                val s = arr[j]
                if (f + s > maxValue) {
                    break
                }
                val nextIndex = deMap[f + s]
                nextIndex?.let {
                    dp[j][it] = dp[i][j] + 1
                    max = maxOf(max, dp[j][it])
                }
            }
        }
        return if (max < 3) 0 else max
    }
}

fun main() {
    println(
        LenLongestFibSubseq_jzof_II_093.lenLongestFibSubseq(
            intArrayOf(1,3,7,11,12,14,18)
        )
    )
}