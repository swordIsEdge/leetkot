package dp.middle

import common.printSelf
import java.util.*

object BicycleYard_LCP_45 {
    fun bicycleYard(position: IntArray, terrain: Array<IntArray>, obstacle: Array<IntArray>): Array<IntArray> {
        val row = terrain.size
        if (row == 0) return arrayOf()
        val col = terrain[0].size
        val dp = Array(row) { Array(col) { BooleanArray(102) } }

        val result = mutableListOf<IntArray>()
        val heap = mutableListOf(intArrayOf(position[0], position[1], 1))
        while (heap.isNotEmpty()) {
            val cur = heap.removeAt(0)
//            println("${cur[0]} ${cur[1]}   ${cur[2]}")
            if (cur[2] <= 0) continue
            if (dp[cur[0]][cur[1]][cur[2]]) continue
            dp[cur[0]][cur[1]][cur[2]] = true
            if (cur[2] == 1 && (cur[0] != position[0] || cur[1] != position[1])) result.add(
                intArrayOf(cur[0], cur[1])
            )
            if (cur[0] > 0) {
                heap.add(
                    intArrayOf(
                        cur[0] - 1,
                        cur[1],
                        cur[2] + terrain[cur[0]][cur[1]] - terrain[cur[0] - 1][cur[1]] - obstacle[cur[0] - 1][cur[1]]

                    )
                )
            }
            if (cur[0] < row - 1) {
                heap.add(
                    intArrayOf(
                        cur[0] + 1,
                        cur[1],
                        cur[2] + terrain[cur[0]][cur[1]] - terrain[cur[0] + 1][cur[1]] - obstacle[cur[0] + 1][cur[1]]

                    )
                )
            }
            if (cur[1] > 0) {
                heap.add(
                    intArrayOf(
                        cur[0],
                        cur[1] - 1,
                        cur[2] + terrain[cur[0]][cur[1]] - terrain[cur[0]][cur[1] - 1] - obstacle[cur[0]][cur[1] - 1]

                    )
                )
            }
            if (cur[1] < col - 1) {
                heap.add(
                    intArrayOf(
                        cur[0],
                        cur[1] + 1,
                        cur[2] + terrain[cur[0]][cur[1]] - terrain[cur[0]][cur[1] + 1] - obstacle[cur[0]][cur[1] + 1]

                    )
                )
            }
        }
        Collections.sort(result) { i1, i2 ->
            if (i1[0] == i2[0]) {
                i1[1] - i2[1]
            } else {
                i1[0] - i2[0]
            }
        }
        return result.toTypedArray()
    }
}

fun main() {
    val r = BicycleYard_LCP_45.bicycleYard(
        intArrayOf(1, 1),
        arrayOf(
            intArrayOf(5, 0), intArrayOf(0, 6)
        ),
        arrayOf(
            intArrayOf(0, 6),
            intArrayOf(7, 0)
        )
    )
    r.forEach { it.printSelf() }
}