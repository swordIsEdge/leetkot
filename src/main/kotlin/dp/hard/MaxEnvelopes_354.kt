package dp.hard

import common.parserArrayIntArray
import common.printSelf
import java.util.*

object MaxEnvelopes_354 {
    fun maxEnvelopes(envelopes: Array<IntArray>): Int {
        Arrays.sort(envelopes) { e1, e2 -> if (e1[0] != e2[0]) e1[0] - e2[0] else e2[1] - e1[1] }
        val envs = mutableListOf<Int>()
        for (envelope in envelopes) {
            val cur = envelope[1]
            if (envs.isEmpty()) {
                envs.add(cur)
            } else if (envs[envs.size - 1] < cur) {
                envs.add(cur)
            } else {
                var left = 0
                var right = envs.size - 1
                while (left < right) {
                    val midIndex = (left + right) shr 1
                    val mid = envs[midIndex]
                    if (mid < cur) {
                        left = midIndex + 1
                    } else {
                        right = midIndex
                    }

                }
                envs[left] = cur
            }
        }
        return envs.size
    }
}

fun main() {
    val args =
        parserArrayIntArray("[[15,8],[2,20],[2,14],[4,17],[8,19],[8,9],[5,7],[11,19],[8,11],[13,11],[2,13],[11,19],[8,11],[13,11],[2,13],[11,19],[16,1],[18,13],[14,17],[18,19]]")
    MaxEnvelopes_354.maxEnvelopes(
        args
    ).printSelf()
}