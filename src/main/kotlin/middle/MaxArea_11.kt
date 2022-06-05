package middle

object MaxArea_11 {
    fun maxArea(height: IntArray): Int {
        if (height.size < 2) return 0
        var i = 0
        var j = height.size - 1
        var max = 0

        while (i < j) {
            max = maxOf(max, minOf(height[i], height[j]) * (j - i))
            if (height[i]<height[j]) i++
            else j--
        }
        return max
    }
}