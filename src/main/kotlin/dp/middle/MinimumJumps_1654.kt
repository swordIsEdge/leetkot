package dp.middle

import java.util.Arrays

object MinimumJumps_1654 {
    private val dp = IntArray(4001)
    private var front = 0
    private  var back:kotlin.Int = 0
    private  var pos:kotlin.Int = 0
    fun minimumJumps(forbidden: IntArray, a: Int, b: Int, x: Int): Int {
        Arrays.fill(dp, Int.MAX_VALUE)
        for (i in forbidden) {
            dp[i] = -1
        }
        front = a
        back = b
        pos = x
        jump(0, 0, false)
        return if (dp[x] == Int.MAX_VALUE) -1 else dp[x]
    }

    fun jump(cur: Int, step: Int, tag: Boolean) {
        if (cur < 0 || cur>4000 || step >= dp[cur]) return
        dp[cur] = step
        if (tag) {
            jump(cur - back, 1 + step, false)
        }
        jump(cur + front, 1 + step, true)
    }
}