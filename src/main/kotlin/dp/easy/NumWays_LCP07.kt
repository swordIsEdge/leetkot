package dp.easy

object NumWays_LCP07 {
    fun numWays(n: Int, relation: Array<IntArray>, k: Int): Int {
        val relations = Array(n) { mutableListOf<Int>() }
        relation.forEach { relations[it[0]].add(it[1]) }
        var reaches = listOf(0)
        for (i in 1..k) {
            reaches = reaches.flatMap { relations[it]}
        }
        return reaches.count { it==n-1 }
    }
}