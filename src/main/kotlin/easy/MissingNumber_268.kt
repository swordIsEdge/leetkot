package easy

object MissingNumber_268 {
    fun missingNumber(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        val inPlace = BooleanArray(nums.size+1){ false}
        nums.forEach { inPlace[it] = true}
        return inPlace.indexOf(false)
    }
}