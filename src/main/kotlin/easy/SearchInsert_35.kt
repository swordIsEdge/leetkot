package easy

object SearchInsert_35 {
    fun searchInsert(nums: IntArray, target: Int): Int {
        if(nums.isEmpty()) return 0
        var left = -1
        var right = nums.size
        while (left + 1 < right) {
            val mid = (left+right)/2
            val m = nums[mid]
            if (m==target) return mid
            if (m<target) left = mid
            else right = mid
        }
        return right

    }
}

fun main() {
    val a = SearchInsert_35.searchInsert(intArrayOf(1, 3, 5, 6), 0)
    println(a)
}