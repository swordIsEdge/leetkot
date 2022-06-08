package easy

object TrailingZeroes_172 {
    fun trailingZeroes(n: Int): Int {
        var base = 5
        var count = 0
        while (base <= n) {
            count += n / base
            base *= 5
        }
        return count
    }
}

fun main() {
    println(TrailingZeroes_172.trailingZeroes(30))
}