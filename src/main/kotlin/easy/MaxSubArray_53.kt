package easy

object MaxSubArray_53 {
    fun maxSubArray(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }
        var max = nums[0]
        var tmp = nums[0]
        for (i in 1 until nums.size) {
            val v = nums[i]
            tmp = maxOf(0, tmp )
            tmp +=v
            max = maxOf(tmp, max)
        }
        return max
    }
}

fun main() {
    val r = MaxSubArray_53.maxSubArray(intArrayOf(-2,1))
    println(r)
}