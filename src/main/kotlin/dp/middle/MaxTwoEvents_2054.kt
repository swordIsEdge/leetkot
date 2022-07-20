package dp.middle

import common.parserArrayIntArray
import common.printSelf

object MaxTwoEvents_2054 {
    fun maxTwoEvents(events: Array<IntArray>): Int {
        events.sortBy { it[0] }
        val stack = mutableListOf<Int>()
        val map = hashMapOf<Int, Int>()
        var res = events[0][2]
        for (event in events) {
            val start = event[0]
            val end = event[1]
            val value = event[2]
            map[end] = maxOf(map.getOrDefault(end, Int.MIN_VALUE), value)
            if (stack.isEmpty()) {
                stack.add(end)
                res = maxOf(res, value)
            } else {
                var hasPre = false
                for (i in stack.size - 1 downTo 0) {
                    if (stack[i] < start) {
                        hasPre = true
                        res = maxOf(res, value + map[stack[i]]!!)
                        break
                    }
                }
                if (!hasPre) {
                    res = maxOf(res, value)

                }
                var first = true
                for (i in stack.size - 1 downTo 0) {
                    if (stack[i] > end) {
                        if (map[stack[i]]!! < map[end]!!) {
                            map[stack[i]] = map[end]!!
                        }
                    } else {
                        first = false
                        if (map[stack[i]]!! < map[end]!!) {
                            stack.add(i + 1, end)
                        }
                        break
                    }
                }
                if (first) {
                    stack.add(0, end)
                }
            }
        }
        return res
    }
}

fun main() {
    MaxTwoEvents_2054.maxTwoEvents(
        parserArrayIntArray("[[10,83,53],[63,87,45],[97,100,32],[51,61,16]]")
    ).printSelf()
}