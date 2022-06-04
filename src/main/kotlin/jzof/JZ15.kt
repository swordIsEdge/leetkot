package jzof

object JZ15 {
    fun NumberOf1(n: Int): Int {
        // write code here
        var num = n
        val base = 0b1
        var count = num and base
        for (i in 1..31) {
            num = num shr 1
            count += (num and base)
        }
        return count
    }

}