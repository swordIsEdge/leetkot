package jzof

import common.TreeNode
import common.buildTreeNode

object JZ54 {
    var node: TreeNode? = null
    fun KthNode(proot: TreeNode?,k: Int): Int  {
        // write code here
        walk(proot,0,k)
        return node?.`val`?:-1
    }

    fun walk(root: TreeNode?, parentWeight: Int, target: Int): Int {
        if (root == null) {
            return parentWeight
        }
        val left = walk(root.left, parentWeight, target)
        if (left < 0) {
            return -1
        }
        if (left + 1 == target) {
            node = root
            return -1
        }
        val right = walk(root.right, left + 1, target)
        if (right < 0) {
            return -1
        }
        return right
    }
}

fun main() {
    val root = buildTreeNode(listOf(5,3,7,2,4,6,8))
    val result = JZ54.KthNode(root, 3)
    print(result)
}