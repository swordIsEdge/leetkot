package topic.rob

import common.TreeNode

object Rob_337 {
    fun rob(root: TreeNode?): Int {
        val p = recurion(root)
        return maxOf(p.first, p.second)
    }
    // 1.有当前节点参与   2. 未参与
    fun recurion(root: TreeNode?): Pair<Int, Int> {
        if (root == null) return Pair(0, 0)
        val left = recurion(root.left)
        val right = recurion(root.right)
        return Pair(
            root.`val`+left.second+right.second,
            maxOf(left.first,left.second)+ maxOf(right.first,right.second)
        )
    }
}