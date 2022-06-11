package dp.middle

import java.util.*

object BestSeqAtIndex_M_17_08 {
    fun bestSeqAtIndex(height: IntArray, weight: IntArray): Int {
        val person = height.indices.map { Pair(height[it], weight[it]) }
//        person.sortedWith { a, b -> if (a.first != b.first) a.first - b.first else b.second - a.second }
        Collections.sort(person) { a, b -> if (a.first != b.first) a.first - b.first else b.second - a.second }
        val dp = mutableListOf<Int>()
        for (person in person) {
            val value = person.second
            if (dp.isEmpty() || dp[dp.size - 1] < value) {
                dp.add(value)
            } else { // binary search
                var left = -1
                var right = dp.size
                while (left + 1 < right) {
                    val midIndex = left + ((right - left) shr 1)
                    val midValue = dp[midIndex]
//                    println("left $left right $right len ${dp.size} mid $midValue  mi $midIndex value $value")
                    // 找到第一个大于等于value的
                    if (midValue < value) {
                        left = midIndex
                    } else {
                        right = midIndex
                    }
                }
                dp[right] = value
            }
        }
        return dp.size
    }
}

fun main() {
    val result = BestSeqAtIndex_M_17_08.bestSeqAtIndex(
        intArrayOf(2868, 5485, 1356, 1306, 6017, 8941, 7535, 4941, 6331, 6181),
        intArrayOf(5042, 3995, 7985, 1651, 5991, 7036, 9391, 428, 7561, 8594)
    )
    println(result)
}