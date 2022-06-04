package jzof

object JZ71 {
    fun jumpFloorII(number: Int): Int {
        // write code here
        if (number == 1) {
            return 1
        }
        var res = 1
        for (i in 2..number) {
            res *= 2
        }
        return res
    }
}