package dp.middle

import common.parserArrayIntArray
import common.printSelf

class MinHeightShelves_1105 {
    var dp: IntArray = IntArray(0)
    fun minHeightShelves(books: Array<IntArray>, shelfWidth: Int): Int {
        val len = books.size
        dp = IntArray(len)
        for (i in len - 1 downTo 0) {
            compute(books, shelfWidth, i, len)
        }
        return dp[0]
    }

    fun compute(books: Array<IntArray>, shelfWidth: Int, index: Int, len: Int) {
        if (index == len - 1) {
            dp[index] = books[index][1]
        } else {
            dp[index] = books[index][1] + dp[index + 1]
            var weight = books[index][0]
            var height = books[index][1]
            for (i in index + 1 until len) {
                weight += books[i][0]
                height = maxOf(height, books[i][1])
                if (weight <= shelfWidth) {
                    dp[index] = minOf(dp[index], height + if (i == len - 1) 0 else dp[i + 1])
                } else {
                    break
                }
            }
        }
    }
}

fun main() {
    val books = parserArrayIntArray(" [[1,1],[2,3],[2,3],[1,1],[1,1],[1,1],[1,2]]")
    val shelfWidth = 4
    val result = MinHeightShelves_1105().minHeightShelves(books, shelfWidth)
    result.printSelf()
}