package medium

import common.TreeNode

object LowestCommonAncestor_236 {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {

        if (root == null) return null
        if (root.`val` == p?.`val` || root.`val` == q?.`val`) return root
        val left = lowestCommonAncestor(root.left, p, q)
        val right = lowestCommonAncestor(root.right, p, q)
        if (left == null) {
            return right
        } else if (right == null) {
            return left
        }
        return root
    }
}