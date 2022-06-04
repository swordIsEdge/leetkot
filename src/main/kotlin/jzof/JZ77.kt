package jzof

import common.TreeNode

object JZ77 {
    fun Print(pRoot: TreeNode?): Array<IntArray> {
        if (pRoot == null) {
            return arrayOf()
        }
        // write code here
        val result = mutableListOf<IntArray>()
        var lastArray = mutableListOf<TreeNode>()
        var tmpArray = mutableListOf<TreeNode>()
        var count = 0
        lastArray.add(pRoot)

        while (lastArray.isNotEmpty()) {
            for (node in lastArray) {
                if (node.left != null) tmpArray.add(node.left!!)
                if (node.right != null) tmpArray.add(node.right!!)
            }
            if (count % 2 == 0) {
                result.add(lastArray.map { it.`val` }.toIntArray())
            } else {
                result.add(lastArray.reversed().map { it.`val` }.toIntArray())
            }

            lastArray = tmpArray
            tmpArray = mutableListOf()
            count++
        }
        return result.toTypedArray()

    }
}