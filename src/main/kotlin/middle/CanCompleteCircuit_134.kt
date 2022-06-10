package middle

object CanCompleteCircuit_134 {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        var spare = 0
        var j = 0
        var mins = Int.MAX_VALUE
        for (i in 0 until gas.size) {
            spare = spare + gas[i] - cost[i]
            if (spare<mins) {
                mins =spare
                j = i
            }

        }
        return if (spare < 0) {
            -1
        } else {
            (j+1)%gas.size
        }

    }
}