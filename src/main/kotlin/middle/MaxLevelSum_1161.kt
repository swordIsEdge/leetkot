package middle

import common.TreeNode

object MaxLevelSum_1161 {
    fun maxLevelSum(root: TreeNode?): Int {
        if (root==null) return 1
        val countMap = hashMapOf<Int,Long>()
        var tmp = mutableListOf<TreeNode>()
        var next = mutableListOf<TreeNode>()
        tmp.add(root)
        var level = 1
        while (tmp.isNotEmpty()) {
            var sum = 0L
            for (node in tmp) {
                sum+=node.`val`
                if (node.left != null) {
                    next.add(node.left!!)
                }
                if (node.right != null) {
                    next.add(node.right!!)
                }
            }
            tmp = next
            next = mutableListOf()
            countMap[level] = sum
            level++
        }
        val min = countMap.values.max()!!
        var minLevel = Int.MAX_VALUE
        for ((k, v) in countMap) {
            if (v == min) {
                minLevel = minOf(minLevel,k)
            }
        }
        return minLevel
    }
}

