package jzof

import common.TreeNode

object JZ28 {
    fun isSymmetrical(pRoot: TreeNode?): Boolean {
        // write code here
        if (pRoot == null) {
            return true
        }
        return help(pRoot.left, pRoot.right)
    }

    fun help(node1: TreeNode?, node2: TreeNode?): Boolean {
        if (node1 == null && node2 == null) {
            return true
        }
        if (node1 == null || node2 == null) {
            return false
        }
        if (node1.`val` != node2.`val`) {
            return false
        }
        return help(node1.left, node2.right) && help(node1.right, node2.left)

    }
}