package easy

import common.TreeNode

object InvertTree_226 {
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root==null) return root
        val left = root.left
        root.left = invertTree(root.right)
        root.right = invertTree(left)
        return root
    }
}