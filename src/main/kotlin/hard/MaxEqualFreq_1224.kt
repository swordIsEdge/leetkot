package hard

import common.printSelf

object MaxEqualFreq_1224 {
    fun maxEqualFreq(nums: IntArray): Int {
        var result = 1

        val numCountMap = hashMapOf<Int, Int>()
        val countCountMap = hashMapOf<Int, Int>()

        for ((index, num) in nums.withIndex()) {
            if (num in numCountMap) {
                val numCount = numCountMap[num]!!
                numCountMap[num] = numCount + 1
                addCount(countCountMap, numCount + 1)
                removeCount(countCountMap, numCount)
            } else {
                numCountMap[num] = 1
                addCount(countCountMap, 1)
            }


            if (check(countCountMap)) {
                result = index + 1
            }
        }
        return result

    }

    fun removeCount(ccMap: MutableMap<Int, Int>, c: Int) {
        val oldC = ccMap.getOrDefault(c, 0)
        when (oldC) {
            0 -> return
            1 -> ccMap.remove(c)
            else -> ccMap[c] = oldC - 1
        }
    }

    fun addCount(ccMap: MutableMap<Int, Int>, c: Int) {
        val oldC = ccMap.getOrDefault(c, 0)
        ccMap[c] = oldC + 1
    }

    fun check(countMap: Map<Int, Int>): Boolean {
        // 只有一个1
        // 一个1，其他相等
        // 其他相等，一个+1
        val size = countMap.size
        return when (size) {
            1 -> countMap.containsKey(1) || countMap.values.toList()[0]==1
            2 -> {
                val keys = countMap.keys.toList().sorted()
                val key0 = keys[0]
                val key1 = keys[1]

                if (key0 == 1) {
                    if (key1 == 2) {
                        countMap[key0] == 1 || countMap[key1] == 1
                    } else {
                        countMap[key0] == 1
                    }
                } else {
                    key0 + 1 == key1 && countMap[key1] == 1
                }
            }
            else -> false
        }
    }
}

fun main() {
    val nums = intArrayOf(1,1,1,2,2,2,3,3,3,4,4,4,5)
    val res = MaxEqualFreq_1224.maxEqualFreq(nums)
    res.printSelf()
}