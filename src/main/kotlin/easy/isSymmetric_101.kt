package easy

import common.TreeNode

object isSymmetric_101 {
    fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) {
            return false
        }
        return isSymmetric(root.left, root.right)
    }

    fun isSymmetric(first: TreeNode?, second: TreeNode?): Boolean {
        if (first == null && second == null) {
            return true
        }
        if (first == null || second == null || first.`val` != second.`val`) {
            return false
        }
        return isSymmetric(first.left, second.right) && isSymmetric(first.right, second.left)
    }
}