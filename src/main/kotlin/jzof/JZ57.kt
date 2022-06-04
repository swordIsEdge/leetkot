package jzof

object JZ57 {
    fun FindNumbersWithSum(array: IntArray, sum: Int): IntArray {
        // write code here
        if (array.size < 2) {
            return intArrayOf()
        }
        var i = 0
        var j = array.size - 1
        while (i < j) {
            val tmp = array[i] + array[j]
            if (tmp == sum) {
                return intArrayOf(array[i], array[j])

            } else if (tmp < sum) {
                i++
            } else {
                j--
            }
        }
        return intArrayOf()
    }
}