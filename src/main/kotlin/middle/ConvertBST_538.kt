package middle

import common.TreeNode

object ConvertBST_538 {
    fun convertBST(root: TreeNode?): TreeNode? {
        dfs(root, 0)
        return root
    }

    fun dfs(root: TreeNode?, `val`: Int):Int {
        if (root==null) return `val`
        if (root.left == null && root.right == null) {
            val res = root.`val`+`val`
            root.`val` = res
            return res
        }
        val rightSum = dfs(root.right, `val`)
        val res = root.`val`+rightSum
        root.`val` = res
        return dfs(root.left,res)
    }
}