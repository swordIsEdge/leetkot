package dp.middle

object MaxRotateFunction_396 {
    fun maxRotateFunction(nums: IntArray): Int {
        if (nums.size < 2) return 0
        val len = nums.size
        val sum = nums.sum()
        val mulSum = nums.mapIndexed { index, i -> index * i }.sum()

        var max = Int.MIN_VALUE
        var tmp = 0
        for (i in nums.indices.reversed()) {
            tmp += sum - len * nums[i]
            max = maxOf(max, tmp)
        }
        return mulSum + max


    }
}

fun main() {
    println(MaxRotateFunction_396.maxRotateFunction(intArrayOf(4, 3, 2, 6)))
}