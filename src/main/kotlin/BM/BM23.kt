package BM

import common.TreeNode

object BM23 {
    fun preorderTraversal(root: TreeNode?): IntArray {
        // write code here
        var ia = intArrayOf()
        root?.let {
            ia = ia.plus(root.`val`)
            ia = ia.plus(preorderTraversal(root.left))
            ia = ia.plus(preorderTraversal(root.right))
        }
        return ia
    }
}