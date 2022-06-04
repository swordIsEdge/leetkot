package jzof

object JZ49 {
    fun GetUglyNumber_Solution(index: Int): Int {
        if (index <= 6) return index

        var ind2 = 0
        var ind3 = 0
        var ind5 = 0
        val result = IntArray(index)
        result[0] = 1
        for (i in 1 until index) {
            result[i] = minOf(result[ind2] * 2, result[ind3] * 3, result[ind5] * 5)
            if (result[i] == result[ind2] * 2) {
                ind2++
            }
            if (result[i] == result[ind3] * 3) {
                ind3++
            }
            if (result[i] == result[ind5] * 5) {
                ind5++
            }
        }
        return result[index - 1]
    }
}

fun main() {
    JZ49.GetUglyNumber_Solution(10)

}