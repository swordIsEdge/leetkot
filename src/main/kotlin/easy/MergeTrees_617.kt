package easy

import common.TreeNode

object MergeTrees_617 {
    fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
        return if (root1 == null && root2 == null) {
            null
        } else if (root1 == null) {
            root2
        } else if (root2 == null) {
            root1
        } else {
            val node = TreeNode(root1.`val` + root2.`val`)
            node.left = mergeTrees(root1.left, root2.left)
            node.right = mergeTrees(root1.right, root2.right)
            node
        }
    }
}