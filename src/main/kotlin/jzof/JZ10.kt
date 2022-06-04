package jzof

object JZ10 {
    fun Fibonacci(n: Int): Int {
        // write code here
        if (n == 1) {
            return 1
        }
        if (n == 2) {
            return 1
        }
        var f = 1
        var s = 1
        var r = 0

        for (i in 3..n) {
            r = f + s
            f = s
            s = r
        }
        return r
    }
}

fun main() {
    print(JZ10.Fibonacci(4))
}