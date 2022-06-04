package jzof

import common.TreeNode

object JZ68 {
    fun lowestCommonAncestor(root: TreeNode?, p: Int, q: Int): Int {
        // write code here
        return commonAncestor(root, p, q)!!.`val`
    }

    fun commonAncestor(root: TreeNode?, p: Int, q: Int): TreeNode? {
        if (root == null || root.`val` == p || root.`val` == q) {
            return root
        }
        val left = commonAncestor(root.left, p, q)
        val right = commonAncestor(root.right, p, q)
        return if (left == null) {
            right
        } else if (right == null) {
            left
        } else root
    }
}