package jzof

object JZ39 {
    fun MoreThanHalfNum_Solution(numbers: IntArray): Int {
        // write code here
        var cnt = 0
        var con = -1
        for (number in numbers) {
            if (cnt == 0) {
                con = number
                cnt=1
            } else if (con == number) {
                cnt++
            } else {
                cnt--
            }
        }
        return con
    }
}