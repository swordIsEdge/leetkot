package middle

import common.TreeNode

object InorderSuccessor_285 {
    var result: TreeNode? = null
    fun inorderSuccessor(root: TreeNode?, p: TreeNode?): TreeNode? {
        if (p == null) return null
        dfs(root, p)
        return result
    }

    fun dfs(root: TreeNode?, p: TreeNode) :Boolean{
        if (root == null) {
            return false
        }
        if (result != null) {
            return false
        }

        if (root.`val` == p.`val`) {
            if (root.right != null) {
                result = find(root.right!!)
            } else {
                return true
            }
        }

        if (root.`val` < p.`val`) {
            val right = dfs(root.right, p)
            if (result!=null) return false
            return right
        } else {
            val left = dfs(root.left, p)
            if (result != null) return false
            if (left) {
                result = root
            }
                return false
        }
    }
    fun find(root: TreeNode) :TreeNode{
        var tmp  = root
        while (tmp.left != null) {
            tmp = tmp.left!!
        }
        return tmp
    }
}