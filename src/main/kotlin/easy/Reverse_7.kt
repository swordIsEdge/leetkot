package easy

object Reverse_7 {
    fun reverse(x: Int): Int {
        if (x == 0) return 0
        if (x < 0) {
            return reverseNeg(x)
        }
        var sum = 0
        var x = x
        while (x > 0) {
            val newSum = sum * 10 + (x % 10)
            if (sum != 0 && newSum / sum < 10) return 0
            sum = newSum
            x = x / 10
        }
        return sum
    }

    fun reverseNeg(x: Int): Int {
        var sum = 0
        var x = x
        while (x != 0) {
            val newSum = sum * 10 + (x % 10)
            if (sum != 0 && newSum / sum < 10) {
                return 0
            }
            sum = newSum
            x = x / 10
        }
        return sum
    }
}

fun main() {
    val r = Reverse_7.reverse(1534236469)
    println(r)
}