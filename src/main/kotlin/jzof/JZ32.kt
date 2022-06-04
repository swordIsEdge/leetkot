package jzof

import common.TreeNode

object JZ32 {
    fun PrintFromTopToBottom(root: TreeNode?): IntArray {
        // write code here
        if (root == null) {
            return intArrayOf()

        }
        val queue = mutableListOf<TreeNode>()
        val result = mutableListOf<Int>()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val node = queue.removeFirst()
            result.add(node.`val`)
            if (node.left != null) {
                queue.add(node.left!!)
            }
            if (node.right != null) {
                queue.add(node.right!!)
            }
        }
        return result.toIntArray()
    }
}