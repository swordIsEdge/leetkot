package medium

import common.TreeNode

object KthSmallest_230 {
    var result: TreeNode? = null
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        kth(root, k, 0)
        return result?.`val`!!

    }

    fun kth(root: TreeNode?, tgt: Int, tmp: Int): Int {
        if (result!=null) return tgt+1
        if (root==null)return tmp

        val left = kth(root.left, tgt, tmp)
        if (left >= tgt) {
            return tgt+1
        }
        val current = left + 1
        if (current == tgt) {
            result = root
            return tgt+1
        }
        val right = kth(root.right,tgt,current)
        return right
    }
}