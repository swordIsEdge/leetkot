package dp.middle

object OptimalDivision_553 {
    fun optimalDivision(nums: IntArray): String {
        if (nums.size==1) return nums[0].toString()
        if (nums.size==2) return "${nums[0]}/${nums[1]}"
        val sb = StringBuilder()
        for ((i, num) in nums.withIndex()) {
            sb.append(num)
            if (i != nums.size - 1) {
                sb.append('/')
            }
            if (i == 0) {
                sb.append('(')
            }
        }
        sb.append(')')
        return sb.toString()
    }
}