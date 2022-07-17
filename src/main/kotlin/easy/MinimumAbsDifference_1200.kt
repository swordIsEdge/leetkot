package easy

object MinimumAbsDifference_1200 {
    fun minimumAbsDifference(arr: IntArray): List<List<Int>> {
        arr.sort()
        val result = mutableListOf<List<Int>>()
        var min = Int.MAX_VALUE
        for (i in 0 until arr.size - 1) {
            val diff = arr[i + 1] - arr[i]
            if (diff > min) {
                continue
            } else if (diff < min) {
                min = diff
                result.clear()
            }
            result.add(listOf(arr[i], arr[i + 1]))
        }
        return result
    }
}