package BM

import common.TreeNode

object BM25 {
    fun postorderTraversal(root: TreeNode?): IntArray {
        // write code here
        var ia = intArrayOf()
        root?.let {
            ia += postorderTraversal(root.left)
            ia += postorderTraversal(root.right)
            ia += root.`val`
        }
        return ia
    }
}