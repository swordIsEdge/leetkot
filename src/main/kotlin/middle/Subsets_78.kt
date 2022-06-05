package middle

object Subsets_78 {
    fun subsets(nums: IntArray): List<List<Int>> {
        var result = List<List<Int>>(1) { listOf() }
        for (num in nums) {
            result = if (result.isEmpty()) {
                listOf(listOf(), listOf(num))
            } else {
                result.flatMap { listOf(it, it + num) }
            }
        }
        return result
    }
}