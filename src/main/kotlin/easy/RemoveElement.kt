package easy

import common.printSelf

object RemoveElement {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        if (nums.size <1) return nums.size
        var slow = 0
        for (fast in nums.indices) {
            if (nums[fast] != `val`) {
                nums[slow++]=nums[fast]
            }
        }
        return slow
    }
}

fun main() {
    val a = intArrayOf(1)
    val r = RemoveElement.removeElement(a,1)
    a.printSelf()
    println(r)
}