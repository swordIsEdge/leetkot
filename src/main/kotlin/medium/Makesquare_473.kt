package medium

object Makesquare_473 {
    fun makesquare(matchsticks: IntArray): Boolean {
        if (matchsticks.isEmpty()) return false
        val sum = matchsticks.sum()
        if (sum % 4 != 0) return false
        val tgt = sum shr 2
        val visited = BooleanArray(matchsticks.size) { false }
        matchsticks.sortDescending()
//        matchsticks.printSelf()
        return dfs(matchsticks, visited, tgt, 0, 0, 0)
    }

    fun dfs(
        matchsticks: IntArray,
        visited: BooleanArray,
        tgt: Int,
        tmp: Int,
        finishedCount: Int,
        startIndex: Int
    ): Boolean {
        if (startIndex >= matchsticks.size) return false
        if (tmp > tgt) return false
        if (finishedCount >= 3) return true
        for (i in startIndex until matchsticks.size) {
            var nextStart = i + 1
            var finishedCount = finishedCount
            if (visited[i]) continue
            var local = tmp + matchsticks[i]
            if (local == tgt) {
//                (items + i).printSelf()
                finishedCount++
                local = 0
                nextStart = 0
            } else if (local > tgt) break

            if (finishedCount >= 3) return true
            visited[i] = true

            val nextResult = dfs(matchsticks, visited, tgt, local, finishedCount, nextStart)
            if (nextResult) return true
            visited[i] = false
        }
        return false
    }

}

fun main() {
    var i = Makesquare_473.makesquare(intArrayOf(5, 5, 5, 5, 16, 4, 4, 4, 4, 4, 3, 3, 3, 3, 4))
    println(i)
}