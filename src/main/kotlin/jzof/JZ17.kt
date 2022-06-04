package jzof

object JZ17 {
    fun printNumbers(n: Int): IntArray  {
        // write code here
        if (n == 0) {
            return IntArray(0)
        }
        var pow = 1
        (1..n).forEach { _ -> pow*=10 }
        return (1 until pow).toList().toIntArray()
    }
}