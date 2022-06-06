package middle

object MinEatingSpeed_875 {
    fun minEatingSpeed_equal(piles: IntArray, h: Int): Int {
        var left = 1
        var right = piles.reduce { acc, i -> maxOf(i, acc) } // 求最大值
        while (left <= right) {
            val mid = (left + right) shr 1
            if (useTimes(piles, mid) <= h) {
                right = mid - 1

            } else {
                left = mid + 1

            }
        }
        return left
    }

    fun minEatingSpeed_great(piles: IntArray, h: Int): Int {
        var left = 1
        var right = piles.reduce { acc, i -> maxOf(i, acc) }
        while (left < right) {
            val mid = (left + right) shr 1
            if (useTimes(piles, mid) <= h) {
                right = mid
            } else {
                left = mid + 1

            }
        }
        return left
//        return right 这个也对
    }

    fun minEatingSpeed_great_plus_one(piles: IntArray, h: Int): Int {
        var left = 1-1
        var right = piles.reduce { acc, i -> maxOf(i, acc) }+1
        while (left + 1 < right) {
            val mid = (left + right) shr 1
            if (useTimes(piles, mid) <= h) {
                right = mid
            } else {
                left = mid
            }
        }
        return right
    }

    fun useTimes(piles: IntArray, k: Int) = piles.map { it + k - 1 }.map { it / k }.sum()

}

fun main() {
    val r = MinEatingSpeed_875.minEatingSpeed_great_plus_one(
        intArrayOf(312884470),
        968709470
    )
    println(r)
}