package jzof

object JZ42 {
    fun FindGreatestSumOfSubArray(array: IntArray): Int {
        // write code here
        var result = array[0]
        var sum = 0
        for (i in array) {
            sum = (if (sum < 0) 0 else sum) + i
            result = maxOf(sum,result)
        }
        return result
    }
}

fun main() {
    val result = JZ42.FindGreatestSumOfSubArray(intArrayOf(1, -2, 3, 10, -4, 7, 2, -5))
    print(result)
}