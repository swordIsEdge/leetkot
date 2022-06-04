package easy

object ContainsDuplicate_217 {
    fun containsDuplicate(nums: IntArray): Boolean {
        val s = hashSetOf<Int>()
        for (num in nums) {
            if (s.contains(num)) {
                return true
            }
            s.add(num)
        }
        return false
    }
}