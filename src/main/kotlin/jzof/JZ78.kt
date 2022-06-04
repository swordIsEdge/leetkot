package jzof

import common.TreeNode

object JZ78 {
    fun Print(pRoot: TreeNode?): Array<IntArray> {
        // write code here
        if (pRoot == null) {
            return arrayOf()
        }
        val result = mutableListOf<IntArray>()
        var last = mutableListOf<TreeNode>()
        var next = mutableListOf<TreeNode>()

        last.add(pRoot)
        while (last.isNotEmpty()) {

            for (node in last) {
                node.left?.let { next.add(it) }
                node.right?.let { next.add(it) }
            }
            result.add(last.map { it.`val` }.toIntArray())
            last = next
            next = mutableListOf()
        }
        return result.toTypedArray()
    }
}