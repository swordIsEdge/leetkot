package middle

import common.TreeNode

object InsertIntoMaxTree_998 {
    fun insertIntoMaxTree(root: TreeNode?, `val`: Int): TreeNode? {
        val node = TreeNode(`val`)
        if (root == null) return node
        val rootValue = root.`val`
        return if (`val` > rootValue) {
            node.left = root
            node
        } else {
            root.right = insertIntoMaxTree(root.right, `val`)
            root
        }
    }
}
