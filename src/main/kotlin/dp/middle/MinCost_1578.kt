package dp.middle

import common.printSelf

object MinCost_1578 {
    fun minCost(colors: String, neededTime: IntArray): Int {
        var sum = neededTime.sumOf { it }
        var max = 0
        println("sum = $sum")
        for ((index, color) in colors.withIndex()) {
            if (index == 0) {
                continue
            } else {
                if (colors[index - 1] == color) {
                    max = maxOf(max,neededTime[index-1])
                    max = maxOf(neededTime[index], max)

                    println("same color $color, max = $max")
                } else {
                    println("remove $max")
                    sum -= max
                    max = 0
                }
            }
        }
        println("remove $max")

        sum -= max
        return sum
    }
}

fun main() {
    val s = "aaabbbabbbb"
    val nt = intArrayOf(
        3, 5, 10,
        7, 5, 3,
        5,
        5, 4, 8, 1
    )

    val res = MinCost_1578.minCost(s, nt)
    res.printSelf()
}