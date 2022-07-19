package dp.middle

import common.printSelf
import kotlin.math.max

object VideoStitching_1024 {
    fun videoStitching(clips: Array<IntArray>, time: Int): Int {
        clips.sortBy { it[0] }
        val len = clips.size
        val dp = IntArray(time + 1) { Int.MAX_VALUE - 2 }

        dp[0] = 0
        for (i in 1..time) {
            for (clip in clips) {
                val start = clip[0]
                val end = clip[1]
                if (i in (start + 1)..end) {
                    dp[i] = minOf(dp[i], dp[start] + 1)
                }
            }
        }
        val res = dp[time]
        return if (res == Int.MAX_VALUE - 2) -1 else res
    }

    fun videoStitching1(clips: Array<IntArray>, time: Int): Int {
        val maxN = IntArray(time + 1)
        for (clip in clips) {
            if (clip[0] < time) {
                maxN[clip[0]] = max(maxN[clip[0]], clip[1])
            }
        }

        var last = 0
        var result = 0
        var pre = 0

        for (i in 0 until time) {
            last = max(last, maxN[i])
            if (i == last) {
                return -1
            }
            if (i == pre) {
                result += 1
                pre = last
            }
        }
        return result
    }

    fun videoStitching2(clips: Array<IntArray>, time: Int): Int {
        val maxn = IntArray(time)
        var last = 0
        var ret = 0
        var pre = 0
        for (clip in clips) {
            if (clip[0] < time) {
                maxn[clip[0]] = Math.max(maxn[clip[0]], clip[1])
            }
        }
        maxn.printSelf()
        for (i in 0 until time) {
            last = Math.max(last, maxn[i])
            println("i = $i, last = $last")
            if (i == last) {
                return -1
            }
            if (i == pre) {
                ret++
                pre = last
            }
        }
        return ret
    }
}

fun main() {
    VideoStitching_1024.videoStitching2(
        arrayOf(
            intArrayOf(0, 2),
            intArrayOf(4, 6),
            intArrayOf(8, 10),
            intArrayOf(1, 9),
            intArrayOf(1, 5),
            intArrayOf(5, 9),
        ),
        10
    )
}