package BM

import common.TreeNode

object BM24 {
    fun inorderTraversal(root: TreeNode?): IntArray {
        // write code here
        var ia = IntArray(0)
        root?.let {
            ia += inorderTraversal(root.left)
            ia += root.`val`
            ia += inorderTraversal(root.right)
        }
        return ia
    }
}