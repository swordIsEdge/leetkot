package middle

import common.TreeNode

object IsValidBST_98 {
    fun isValidBST(root: TreeNode?): Boolean {
        if (root == null) return true
        val p = helper(root)
        return p != ERROR
    }

    val ERROR = Pair(-1, 1)

    fun helper(root: TreeNode): Pair<Int, Int> {
        var first = 0
        var second = 0
        if (root.left != null) {
            val l = helper(root.left!!)
            if (l == ERROR) return ERROR
            if (l.second >= root.`val`) {
                return ERROR
            } else first = l.first
        } else {
            first = root.`val`
        }
        if (root.right != null) {
            val r = helper(root.right!!)
            if (r == ERROR) return ERROR
            if (r.first <= root.`val`) {
                return ERROR
            }
            second = r.second
        }
        else second = root.`val`
        return Pair(first, second)
    }

}