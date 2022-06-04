package jzof

object JZ81 {

    fun reOrderArrayTwo(array: IntArray): IntArray {
        // write code here
        var left = 0
        var right = array.size - 1
        while (left<right) {
            while (left<array.size && array[left] % 2 == 1) {
                left++
            }
            while (right >= 0 && array[right] % 2 == 0) {
                right--
            }
            if (left >= right) {
                break
            }
            val tmp = array[left]
            array[left] = array[right]
            array[right] = tmp
        }
        return array
    }
}