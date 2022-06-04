package medium

import common.TreeNode
import common.buildTreeNode

object PathSum_437 {
    val map = hashMapOf<Int, Int>()
    fun pathSum(root: TreeNode?, targetSum: Int): Int {
        if (root == null) {
            return 0
        }
        map[0] = 1
        return preOrder(root, 0, targetSum)
    }

    fun preOrder(root: TreeNode, preLen: Int, targetSum: Int): Int {
        val tmpLen = preLen + root.`val`

        val tmpCount = map.getOrDefault(tmpLen - targetSum, 0)
        val preLenCount = map.getOrDefault(tmpLen, 0)
        map[tmpLen] = preLenCount + 1
        println("val ${root.`val`} has tmpCount $tmpCount")
        val leftCount = root.left?.let { preOrder(it, tmpLen, targetSum) } ?: 0
        val rightCount = root.right?.let { preOrder(it, tmpLen, targetSum) } ?: 0
        map[tmpLen] = preLenCount
        return tmpCount + leftCount + rightCount
    }
}

fun main() {
    val node = buildTreeNode(listOf(10, 5, -3, 3, 2, null, 11, 3, -2, null, 1))
    val result = PathSum_437.pathSum(node, 8)
    println(result)
}