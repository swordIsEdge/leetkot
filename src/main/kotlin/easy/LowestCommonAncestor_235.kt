package easy

import common.TreeNode

object LowestCommonAncestor_235 {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null) return null
        if (root.`val` == p?.`val` || root.`val` == q?.`val`) return root
        val left = lowestCommonAncestor(root.left, p, q)
        val right = lowestCommonAncestor(root.right, p, q)

        if (left!=null && right!=null) return root
        if (left!=null) return left
        if (right!=null) return right
        return null

    }
}