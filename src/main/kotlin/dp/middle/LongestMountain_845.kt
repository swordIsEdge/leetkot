package dp.middle

object LongestMountain_845 {
    fun longestMountain(arr: IntArray): Int {
        val len = arr.size
        if (len < 3) return 0
        val left = IntArray(len) { 1 }
        val right = IntArray(len) { 1 }
        for (i in 1 until len) {
            if (arr[i] > arr[i - 1]) left[i] = left[i - 1] + 1
        }
        for (i in len - 2 downTo 0) {
            if (arr[i] > arr[i + 1]) right[i] = right[i + 1] + 1
        }
        var max = 1
        for (i in 1 until len) {
            if (left[i] == 1 || right[i] == 1) continue
            val cur = left[i] + right[i] - 1
            max = maxOf(max, cur)
        }
        return if (max==1) 0 else max
    }
}