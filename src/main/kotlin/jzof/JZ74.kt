package jzof

object JZ74 {
    fun FindContinuousSequence(sum: Int): Array<IntArray> {
        // write code here
        val result = mutableListOf<IntArray>()
        var i = 1
        var j = 1

        var tmpSum = 1
        while (j < sum && i <= j) {
            if (tmpSum < sum) {
                j++
                tmpSum += j
            } else if (tmpSum > sum) {
                tmpSum -= i
                i++
            } else {
                result.add((i..j).toList().toIntArray())
                tmpSum -= i
                i++
            }
        }
        return result.toTypedArray()
    }
}

fun main() {
    val result = JZ74.FindContinuousSequence(9)
}