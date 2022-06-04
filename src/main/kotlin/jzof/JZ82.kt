package jzof

import common.TreeNode

object JZ82 {
    fun hasPathSum(root: TreeNode?, sum: Int): Boolean {
        // write code here
        return hasPathSum(root, sum, 0)
    }

    fun hasPathSum(root: TreeNode?, tgt: Int, tmp: Int): Boolean {
        // write code here
        if (root == null) {
            return false
        }
        val newTmp = tmp + root.`val`
        return if (root.left == null && root.right == null) {
            newTmp == tgt
        } else {
            hasPathSum(root.left, tgt, newTmp) || hasPathSum(root.right, tgt, newTmp)
        }
    }
}