package medium

import java.util.*

object SubarraySum_560 {
    fun subarraySum(nums: IntArray, k: Int): Int {
        val queue = LinkedList<Int>()
        queue.offer(0)
        var sum = 0
        for (num in nums) {
            sum += num
            queue.offer(sum)
        }

        var count = 0
        val map = hashMapOf<Int, Int>()
        while (queue.isNotEmpty()) {
            val tmp = queue.poll()
            if (tmp in map.keys) {
                count += map[tmp]!!
//                set.remove(tmp)
            }
            map[tmp + k] = map.getOrDefault(tmp + k, 0) + 1
        }


        return count

    }
}

fun main() {
    val r = SubarraySum_560.subarraySum(intArrayOf(1, -1, 0), 0)
    println(r)
}