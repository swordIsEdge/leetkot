package hard

object Trap_42 {
    fun trap(height: IntArray): Int {
        if (height.size <= 2) return 0
        val leftMax = IntArray(height.size) { 0 }
        val rightMax = IntArray(height.size) { 0 }
        for (i in 1 until height.size) {
            leftMax[i] = maxOf(leftMax[i - 1], height[i - 1])
        }
        for (i in height.size - 2 downTo 0) {
            rightMax[i] = maxOf(rightMax[i + 1], height[i + 1])
        }
        return (1 until height.size - 1).map { minOf(leftMax[it], rightMax[it]) - height[it] }.map { maxOf(it, 0) }
            .sum()
    }

    fun trap2(height: IntArray): Int {
        if (height.size <= 2) return 0
        var left = 0
        var right = height.size - 1
        var leftMax = height[left]
        var rightMax = height[right]
        var result = 0
        while (left <= right) {
            if (leftMax <= rightMax) {
                leftMax = maxOf(leftMax,height[left])
                result+= leftMax-height[left++]
            } else {
                rightMax = maxOf(rightMax,height[right])
                result+= rightMax-height[right--]
            }
        }
        return result
    }

}

fun main() {
    val result = Trap_42.trap(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1))
    println(result)
}