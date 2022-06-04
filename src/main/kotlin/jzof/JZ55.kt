package jzof

import common.TreeNode

object JZ55 {
    fun TreeDepth(pRoot: TreeNode?): Int {
        // write code here
        return pRoot?.let { 1 + maxOf(TreeDepth(pRoot.left), TreeDepth(pRoot.right)) } ?: 0
    }
}