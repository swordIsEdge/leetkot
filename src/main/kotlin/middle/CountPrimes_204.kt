package middle

import kotlin.math.sqrt

object CountPrimes_204 {
    fun countPrimes(n: Int): Int {
        if (n <= 2) return 0
        val flag = BooleanArray(n)
        var count = 0

        val mulEnd = sqrt(n * 1.0)
        for (i in 2 until n) {
            if (flag[i]) continue

            count++
            flag[i] = true
            if (i <= mulEnd) {
                for (j in i..n) {
                    if (i * j >= n) {
                        break
                    }
                    flag[i * j] = true
                }
            }
        }
        return count
    }
}

fun main() {
    val r = CountPrimes_204.countPrimes(999983)
    println(r)
}