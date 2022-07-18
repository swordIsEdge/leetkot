package middle

import common.printSelf

object ArrayNesting_565 {
    fun arrayNesting(nums: IntArray): Int {
        val map = nums.mapIndexed { index, num -> num to index }.toMap()
        val visited = BooleanArray(nums.size)
        val result = hashMapOf<Int, Int>()
        for ((index,num) in nums.withIndex()) {
            if (visited[index]) {
                continue
            }
            result[index] = closure(index,nums,map,visited)
        }
        return result.values.max()
    }
    fun closure(start: Int, nums: IntArray, map: Map<Int, Int>, visited: BooleanArray): Int {
        var count = 0

        var next = start
        while (!visited[next]) {
            count++
            visited[next] = true
            next = nums[next]
        }
        return count
    }
}

fun main() {
    val params = intArrayOf(5,4,0,3,1,6,2)
    val result = ArrayNesting_565.arrayNesting(params)
    result.printSelf()
}