package medium

import common.TreeNode

object LevelOrder_102 {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return listOf()
        val result = mutableListOf<List<Int>>()
        val queue = mutableListOf<List<TreeNode>>()
        queue.add(listOf(root))
        while (queue.isNotEmpty()) {
            val cur = queue.removeFirst()
            cur.map { it.`val` }.let { if (it.isNotEmpty()) result.add(it) }
            val next = cur.map { listOf(it.left, it.right) }.flatten().filterNotNull()
            next.let { if (it.isNotEmpty()) queue.add(it) }
        }
        return result
    }
}