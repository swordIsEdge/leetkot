package medium

import common.TreeNode
import common.buildTreeNode

object DeleteNode_450 {
    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        if (root == null) return root
        val preRoot = TreeNode(Int.MIN_VALUE)
        preRoot.right = root
        val pair = find(preRoot, key) ?: return root

        val f = pair.first
        val k = pair.second

        removeChild(f, k)

        return preRoot.right
    }

    fun removeChild(parent: TreeNode, child: TreeNode) {
        if (child == parent.left) {
            if (child.left != null) {
                parent.left = child.left
                if (child.right != null) {
                    var tmp = parent.left!!
                    while (tmp.right != null) {
                        tmp = tmp.right!!
                    }
                    tmp.right = child.right
                }
            } else {
                parent.left = child.right
            }
        } else {
            if (child.left != null) {
                parent.right = child.left
                if (child.right != null) {
                    var tmp = parent.right!!
                    while (tmp.right != null) {
                        tmp = tmp.right!!
                    }
                    tmp.right = child.right
                }
            } else {
                parent.right = child.right
            }

        }
    }

    fun find(root: TreeNode?, key: Int): Pair<TreeNode, TreeNode>? {
        if (root == null) return null
        if (root.`val` == key) return Pair(root, root)
        if (root.left?.`val` == key) return Pair(root, root.left!!)
        if (root.right?.`val` == key) return Pair(root, root.right!!)

        return if (root.`val`>key) find(root.left, key) else find(root.right, key)
    }
}

fun main() {
    val t = buildTreeNode(listOf(5,3,6,2,4,null,7))
    val result = DeleteNode_450.deleteNode(t, 3)
    println(result?.`val`)

}