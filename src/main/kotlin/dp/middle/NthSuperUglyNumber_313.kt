package dp.middle

import java.util.PriorityQueue

object NthSuperUglyNumber_313 {
    data class Ugly(
        val ugly: Int,
        val index: Int,
        val prime: Int
    )

    fun nthSuperUglyNumber(n: Int, primes: IntArray): Int {
        val heap = PriorityQueue<Ugly> { u1, u2 -> u1.ugly.compareTo(u2.ugly) }
        primes.forEach { heap.offer(Ugly(it, 0, it)) }
        val dp = IntArray(n) { 1 }
        for (i in 1 until n) {
            dp[i] = heap.peek().ugly
            while (dp[i] == heap.peek().ugly) {
                val (_, ind, p) = heap.poll()
                heap.offer(Ugly(dp[ind] * p, ind + 1, p))
            }
        }
        return dp[n - 1]
    }
}