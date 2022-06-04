package easy

import common.TreeNode

object SumRootToLeaf_1022 {
    fun sumRootToLeaf(root: TreeNode?): Int {
        if (root == null) return 0
        return sum(root, 0)
    }

    fun sum(root: TreeNode?, last: Int): Int {
        if (root == null) return 0
        val tmp = (last shl 1) or root.`val`
        if (root.left == null && root.right == null) {
            return tmp
        } else {
            return sum(root.left, tmp) + sum(root.right, tmp)
        }
    }
}