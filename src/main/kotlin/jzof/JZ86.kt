package jzof

import common.TreeNode

object JZ86 {
    fun lowestCommonAncestor(root: TreeNode?, o1: Int, o2: Int): Int {
        // write code here
        if (root == null) {
            return -1
        }
        return dfs(root, o1, o2)?.`val` ?: 0
    }

    fun dfs(root: TreeNode?, p: Int, q: Int): TreeNode? {
        if (root == null) {
            return null
        }
        if (root.`val` == p || root.`val` == q) {
            return root
        }
        val left = dfs(root.left, p, q)
        val right = dfs(root.right, p, q)
        if (left == null) {
            return right
        }
        if (right == null) {
            return left
        }
        return root
    }
}