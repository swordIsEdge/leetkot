package jzof

object JZ85 {
    fun FindGreatestSumOfSubArray(array: IntArray): IntArray {
        // write code here
        var max = array[0]
        var maxIndex = 0

        var temp =  array[0]

        val dp = IntArray(array.size)
        dp[0] = 0
        for ((ind, value) in array.withIndex()) {
            if (ind == 0) {
                continue
            }

            if (temp == 0) {
                dp[ind] = dp[ind - 1]
            } else if (temp < 0) {
                dp[ind] = ind
                temp = 0
            } else {
                dp[ind] = dp[ind - 1]
            }
            temp += value

            if (temp > max || temp==max && ind - dp[ind] >= maxIndex - dp[maxIndex]) {
                max = temp
                maxIndex = ind
            }
        }
        return array.sliceArray(dp[maxIndex]..maxIndex)
    }
}

fun main() {
    val result = JZ85.FindGreatestSumOfSubArray(intArrayOf(0,0,0,0,-1,1,-2))
    for (r in result) {
        print("$r->")
    }
}