package dp.easy

object ReverseBits_05_03 {
    fun reverseBits(num: Int): Int {
        val isBitOne = BooleanArray(32) { false }
        for (i in 0..31) {
            isBitOne[31 - i] = (num shr i) and 1 != 0
        }
        val dp1 = IntArray(32) { 0 }
        dp1[0] = if (isBitOne[0]) 1 else 0
        var max = 1
        for (i in 1..31) {
            dp1[i] = if (isBitOne[i]) dp1[i - 1] + 1 else 0
            max = maxOf(max, dp1[i]+1)
        }

        for (i in 1..31) {
            if (dp1[i] > 0) {
                val last = i - dp1[i] - 1
                if (last >= 0) {
                    max = maxOf(max, dp1[last] + 1 + dp1[i])
                }
            }
        }
        return minOf(max, 32)
    }
}