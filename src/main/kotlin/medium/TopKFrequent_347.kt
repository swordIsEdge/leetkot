package medium

object TopKFrequent_347 {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val map = hashMapOf<Int, Int>()
        for (num in nums) {
            map[num] = map.getOrDefault(num, 0) + 1
        }
        val values = map.values.toList().sortedDescending()
        if (values.size<=k) return map.keys.toIntArray()
        val tgt = values[k-1]
        return map.filter { it.value>=tgt }.keys.toIntArray()

    }
}