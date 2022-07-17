package dp.hard

object CanCross_403 {
    fun canCross(stones: IntArray): Boolean {
        val dp = List<MutableSet<Int>>(stones.size) { hashSetOf() }
        dp[0].add(0)
        val map = stones.withIndex().map { (index,item)->item to index }.toMap()
        for (i in stones.indices) {
            val tmpSet = dp[i]
            val tmpLocation = stones[i]

            for (lastStep in tmpSet) {
                val newStep = listOf(lastStep-1,lastStep,lastStep+1).filter { it > 0 }
                for (step in newStep) {
                    val nextLocation = tmpLocation + step
                    if (map.containsKey(nextLocation)) {
                        dp[map[nextLocation]!!].add(step)
                    }
                }
            }
        }
        return dp[dp.size-1].size>0
    }
}