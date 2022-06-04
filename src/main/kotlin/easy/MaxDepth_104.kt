package easy

import common.TreeNode

object MaxDepth_104 {
    fun maxDepth(root: TreeNode?): Int {
        return if (root == null) {
            0
        } else if (root.left == null && root.right == null) {
            1
        } else 1 + maxOf(maxDepth(root.left), maxDepth(root.right))
    }
}