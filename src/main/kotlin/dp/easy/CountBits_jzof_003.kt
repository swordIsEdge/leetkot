package dp.easy

object CountBits_jzof_003 {
    fun countBits(n: Int): IntArray {
        if (n == 0) {
            return intArrayOf(0)
        }
        var base = 1
        val result = IntArray(n+1){ 0}
        for (i in 1..n) {
            if (i == base) {
                result[i] = 1
                base = base shl 1
            } else {
                result[i] = result[i-base/2]+1

            }
        }
        return result

    }
}