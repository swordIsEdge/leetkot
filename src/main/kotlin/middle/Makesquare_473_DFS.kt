package middle

object Makesquare_473_DFS {
    var tgt = 0
    var ms: IntArray = IntArray(0)
    fun makesquare(matchsticks: IntArray): Boolean {
        if (matchsticks.isEmpty()) return false
        val sum = matchsticks.sum()
        if (sum % 4 != 0) return false
        matchsticks.sortDescending()

        tgt = sum shr 2
        ms = matchsticks

        return dfs(0, IntArray(4) { 0 })
    }

    fun dfs(index: Int, state: IntArray): Boolean {
        if (index >= ms.size) {
            return state.all { it == tgt }
        }
        val tmp = ms[index]
        for (i in state.indices) {
            if (state[i] + tmp > tgt) {
                continue
            }
            state[i] += tmp
            val nextResult = dfs(index + 1, state)
            if (nextResult) return nextResult
            state[i] -= tmp
        }
        return false
    }


}

fun main() {
//    var i = Makesquare_473.makesquare(intArrayOf(5, 5, 5, 5, 16, 4, 4, 4, 4, 4, 3, 3, 3, 3, 4))
//    println(i)
}