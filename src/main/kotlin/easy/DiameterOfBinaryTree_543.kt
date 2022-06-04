package easy

import common.TreeNode

object DiameterOfBinaryTree_543 {
    var max = 0
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        ruc(root)
        return max
    }

    private fun ruc(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val left = ruc(root.left)
        val right = ruc(root.right)
        max = maxOf(max, left + right)
        return maxOf(left, right) + 1
    }
}