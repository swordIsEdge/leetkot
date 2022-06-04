package jzof

object JZ64 {
    var res = 0
    fun Sum_Solution(n: Int): Int {
        // write code here
        val flag = (n > 1) && Sum_Solution(n - 1) > 0
        res += n
        return res
    }
}