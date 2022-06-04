package jzof

object JZ3 {
    fun duplicate(numbers: IntArray): Int  {
        // write code here
        val set = mutableSetOf<Int>()
        for (number in numbers) {
            if (number in set) {
                return number
            } else {
                set.add(number)
            }
        }
        return -1


    }
}