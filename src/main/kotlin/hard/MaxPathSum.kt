package hard

import common.TreeNode

object MaxPathSum {
    var max = Int.MIN_VALUE

    fun maxPathSum(root: TreeNode?): Int {
        if (root == null)
            return 0
        recursion(root)
        return max
    }

    fun recursion(root: TreeNode?): Int =
        if (root == null) 0
        else if (root.left == null && root.right == null) {
            max = maxOf(max, root.`val`)
            root.`val`
        } else {
            val left = maxOf(recursion(root.left), 0)
            val right = maxOf(recursion(root.right), 0)
            max = maxOf(max, root.`val` + left + right)
            root.`val` + maxOf(left, right)
        }
}