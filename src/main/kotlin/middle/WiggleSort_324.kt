package middle

object WiggleSort_324 {
    fun wiggleSort(nums: IntArray): Unit {
        val count = IntArray(5001)
        var max = 0
        nums.forEach {
            max = maxOf(it, max)
            count[it]++
        }

        for (i in nums.indices step 2) {
            while (count[max]==0) max--
            count[max]--
            nums[i] = max

        }
        for (i in 1 until nums.size step 2) {
            while (count[max]==0) max--
            count[max]--
            nums[i] = max

        }
    }
}