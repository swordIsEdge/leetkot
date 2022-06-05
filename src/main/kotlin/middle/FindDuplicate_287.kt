package middle

object FindDuplicate_287 {
    fun findDuplicate(nums: IntArray): Int {
        val n = nums.size - 1
        var left = 1
        var right = n
        var ans = -1
        while (left <= right) {
            val middle = (left + right) shr 1
            val count = nums.count { it <= middle }
            if (count <= middle) left = middle + 1
            else {
                ans = middle
                right = middle-1
            }
        }
        return ans
    }
}

fun main() {
    val r = FindDuplicate_287.findDuplicate(intArrayOf(1, 3, 4, 2, 2))
    println(r)

}