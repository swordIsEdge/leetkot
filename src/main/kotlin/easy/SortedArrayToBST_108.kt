package easy

import common.TreeNode

object SortedArrayToBST_108 {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        if (nums.isEmpty()) return null
        return build(nums, 0, nums.size - 1)
    }
    fun build(nums: IntArray, start: Int, end: Int): TreeNode? {
        println("$start -> $end")
        if (start == end) {
            return TreeNode(nums[start])
        }
        if (start > end) {
            return null
        }
        val mid = (start+end)/2
        val node = TreeNode(nums[mid])
        node.left = build(nums,start,mid-1)
        node.right = build(nums,mid+1,end)
        return node
    }
}

fun main() {
    val r = SortedArrayToBST_108.sortedArrayToBST(intArrayOf(-10, -3, 0, 5, 9))
    println(r?.`val`)

}