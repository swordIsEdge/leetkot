package hard

object Candy_135 {
    fun candy(ratings: IntArray): Int {
        val s = ratings.size
        if (s<=1) return s
        val flags = IntArray(ratings.size) { 0 }
        flags[0] = if (ratings[0] > ratings[1]) 1 else 0
        flags[s - 1] = if (ratings[s - 1] > ratings[s - 2]) 2 else 0
        for (i in 1 until s - 1) {
            flags[i] = if (ratings[i] <= ratings[i - 1] && ratings[i] <= ratings[i + 1]) 0
            else if (ratings[i] > ratings[i - 1] && ratings[i] > ratings[i + 1]) 3
            else if (ratings[i] > ratings[i - 1]) 2
            else 1

        }
        val result = IntArray(ratings.size) { 0 }
        for (i in flags.indices) {
            if (flags[i] == 0) {
                var tmp = 1
                result[i] = 1
                var left = i - 1
                while (left >= 0 && (flags[left] == 1 || flags[left] == 3)) {
                    result[left] = maxOf(result[left], ++tmp)
                    left--
                }
                tmp = 1
                var right = i + 1
                while (right < s && (flags[right] == 2 || flags[right] == 3)) {
                    result[right] = maxOf(result[right], ++tmp)
                    right++
                }
            }
        }
        return result.sum()
    }
}

fun main() {
    val r = Candy_135.candy(intArrayOf(1, 6, 10, 8, 7, 3, 2))
    println(r)
}