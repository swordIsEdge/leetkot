package medium

object MaxProduct_152 {
    fun maxProduct(nums: IntArray): Int {
        val posiDP = IntArray(nums.size)
        val negaDP = IntArray(nums.size)

        posiDP[0] = nums[0]
        negaDP[0] = nums[0]
        var max = nums[0]
        for (index in 1 until nums.size) {
            val value = nums[index]
            if (value == 0) {
                posiDP[index] = 0
                negaDP[index] = 0
            } else if (value > 0) {
                posiDP[index] = if (posiDP[index - 1] <= 0) value else value * posiDP[index - 1]
                negaDP[index] = if (negaDP[index - 1] >= 0) value else value * negaDP[index - 1]
            } else { //负数
                posiDP[index] = if (negaDP[index - 1] >= 0) value else negaDP[index - 1] * value
                negaDP[index] = if (posiDP[index - 1] <= 0) value else posiDP[index - 1] * value

            }
            max = maxOf(max, posiDP[index])
        }
        return max
    }
}

fun main() {
    println(MaxProduct_152.maxProduct(intArrayOf(-2, 0, 1)))
}