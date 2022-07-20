package dp.middle

import common.parserArrayIntArray
import common.printSelf
import kotlin.math.max

object MostPoints_2140 {
    fun mostPoints(questions: Array<IntArray>): Long {
        val len = questions.size
        val dp = Array(len) { LongArray(2) }
        var result = 0L
        for ((index, question) in questions.withIndex()) {
            val point = question[0]
            val brainPower = question[1]
            if (index == 0) {
                dp[0][0] = 0
                dp[0][1] = point.toLong()
            } else {
                dp[index][0] = max(dp[index][0], dp[index - 1][0])
                dp[index][1] = dp[index][0] + point
            }
            val nextIndex = index + brainPower + 1
            if (nextIndex < len) {
                dp[nextIndex][0] = max(dp[nextIndex][0],dp[index][1])
            }
            result = max(result, dp[index][1])

        }
        return result
    }
}

fun main() {
    val params = parserArrayIntArray("[[21,5],[92,3],[74,2],[39,4],[58,2],[5,5],[49,4],[65,3]]")

    val result = MostPoints_2140.mostPoints(params)
    result.printSelf()
}