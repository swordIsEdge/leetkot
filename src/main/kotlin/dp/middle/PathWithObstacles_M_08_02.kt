package dp.middle

object PathWithObstacles_M_08_02 {
    fun pathWithObstacles(obstacleGrid: Array<IntArray>): List<List<Int>> {
        // 1障碍物  0 可行
        val r = obstacleGrid.size
        if (r == 0 || obstacleGrid[0][0] == 1) return listOf()
        val c = obstacleGrid[0].size

        val dp = Array(r) { Array<Pair<Int, Int>?>(c) { null } }
        dp[0][0] = Pair(-1, -1)

        (1 until r).forEach {
            dp[it][0] = if (obstacleGrid[it][0] == 1 || dp[it - 1][0] == null) {
                null
            } else {
                Pair(it - 1, 0)
            }
        }
        (1 until c).forEach {
            dp[0][it] = if (obstacleGrid[0][it] == 1 || dp[0][it - 1] == null) {
                null
            } else {
                Pair(0, it - 1)
            }
        }

        for (i in 1 until r) {
            for (j in 1 until c) {
                dp[i][j] = if (obstacleGrid[i][j] == 1) null
                else if (dp[i - 1][j] != null) {
                    Pair(i - 1, j)
                } else if (dp[i][j - 1] != null) {
                    Pair(i, j - 1)
                } else {
                    null
                }
            }
        }

        if (dp[r - 1][c - 1] == null) {
            return listOf()
        } else {
            val result = mutableListOf<List<Int>>()
            var cur = Pair(r-1,c-1)
            while (true) {
                result.add(listOf(cur.first, cur.second))
                if (cur.first <= 0 && cur.second <= 0) {
                    break
                }
                cur = dp[cur.first][cur.second]!!
            }
            return result.reversed()
        }

    }
}

fun main() {
    PathWithObstacles_M_08_02.pathWithObstacles(
        arrayOf(
            intArrayOf(0,1),
            intArrayOf(0,1)
        )
    )
}