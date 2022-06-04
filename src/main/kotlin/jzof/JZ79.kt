package jzof

import common.TreeNode
import kotlin.math.abs

object JZ79 {
    fun IsBalanced_Solution(pRoot: TreeNode?): Boolean {
        // write code here
        return test(pRoot) >= 0
    }

    fun test(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val left = test(root.left)
        if (left < 0) {
            return left
        }
        val right = test(root.right)
        if (right < 0) {
            return right
        }
        if (abs(left - right) > 1) {
            return -1
        }
        return maxOf(left, right) + 1
    }
}