package jzof

import common.TreeNode

object JZ7 {
    fun reConstructBinaryTree(pre: IntArray, vin: IntArray): TreeNode? {
        return build(pre, 0, pre.size - 1, vin, 0, vin.size - 1)
    }

    fun build(pre: IntArray, preStart: Int, preEnd: Int, vin: IntArray, vinStart: Int, vinEnd: Int): TreeNode? {
        if (preStart > preEnd) {
            return null
        }
        val rootValue = pre[preStart]
        val rootNode = TreeNode(rootValue)

        var vinIndex = -1
        for (i in vinStart..vinEnd) {
            if (rootValue == vin[i]) {
                vinIndex = i
                break
            }
        }
        val leftSize = vinIndex - vinStart
        val rightSize = vinEnd - vinIndex

        rootNode.left = build(pre, preStart + 1, preStart + leftSize, vin, vinStart, vinIndex - 1)
        rootNode.right = build(pre, preEnd - rightSize + 1, preEnd, vin, vinIndex + 1, vinEnd)
        return rootNode
    }

}