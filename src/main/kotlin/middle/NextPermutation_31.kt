package middle

import java.util.*

object NextPermutation_31 {
    fun nextPermutation(nums: IntArray): Unit {
        if (nums.size < 2) return

        val stack = LinkedList<Int>()

        var maxValue = nums.size - 1
        stack.push(maxValue)

        for (i in (nums.size - 2) downTo 0) {
            val local = nums[i]
            if (local >= nums[maxValue]) {
                maxValue = i
                stack.push(i)
            } else {
                var last = maxValue
                while (stack.isNotEmpty() && nums[stack.peek()] > local) {
                    last = stack.pop()
                }
                val tmp = nums[i]
                nums[i] = nums[last]
                nums[last] = tmp

                nums.sort(i+1,nums.size)
                return
            }
        }
        nums.reverse()
    }
}

fun main() {
    val array = intArrayOf(7,8,6)
    NextPermutation_31.nextPermutation(array)
    for (i in array) {
        println("$i->")
    }
}