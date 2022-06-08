package middle

import common.TreeNode

object ZigzagLevelOrder_103 {
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) {
            return listOf()
        }
        // write code here
        val result = mutableListOf<List<Int>>()
        var lastArray = mutableListOf<TreeNode>()
        var tmpArray = mutableListOf<TreeNode>()
        var count = 0
        lastArray.add(root)

        while (lastArray.isNotEmpty()) {
            for (node in lastArray) {
                if (node.left != null) tmpArray.add(node.left!!)
                if (node.right != null) tmpArray.add(node.right!!)
            }
            if (count % 2 == 0) {
                result.add(lastArray.map { it.`val` })
            } else {
                result.add(lastArray.reversed().map { it.`val` })
            }

            lastArray = tmpArray
            tmpArray = mutableListOf()
            count++
        }
        return result
    }
}