package jzof

import common.TreeNode

object JZ27 {
    fun Mirror(pRoot: TreeNode?): TreeNode?  {
        // write code here
        if (pRoot == null) {
            return pRoot
        }
        val tmp = Mirror(pRoot.left)
        pRoot.left = Mirror(pRoot.right)
        pRoot.right = tmp
        return pRoot
    }
}