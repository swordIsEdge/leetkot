package easy

object IsPowerOfThree_326 {
    fun isPowerOfThree(n: Int): Boolean {
        if (n <= 0) return false
        if (n == 1) return true
        var x = n
        while (x > 1) {
            if (x % 3 != 0) {
                return false
            }
            x = x / 3
        }
        return x == 1
    }
}

fun main() {
    println(IsPowerOfThree_326.isPowerOfThree(27))
}