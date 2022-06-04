package jzof

object JZ21 {
    fun reOrderArray(array: IntArray): IntArray {
        // write code here
        for ((i, value) in array.withIndex()) {
            if (value % 2 == 1) {
                continue
            }
            var nextOddIndex = -1
            for (j in i + 1 until array.size) {
                if (array[j] % 2 == 1) {
                    nextOddIndex = j
                    break
                }
            }
            if (nextOddIndex > 0) {
                val nextOdd = array[nextOddIndex]
                for (j in nextOddIndex downTo i + 1) {
                    array[j] = array[j - 1]
                }
                array[i] = nextOdd
            }
        }
        return array
    }

}