package jzof

import common.TreeNode

object JZ84 {
    var tgt = 0
    var result = 0
    val map = mutableMapOf<Int, Int>()

    fun FindPath(root: TreeNode?, sum: Int): Int {
        tgt = sum
        map[0] = 1
        return dfs(root, 0)
    }

    fun dfs(root: TreeNode?, tmp: Int): Int {
        if (root == null) {
            return 0
        }
        val local = tmp + root.`val`


        val count = map.getOrDefault(local - tgt, 0)

        map[local] = map.getOrDefault(local, 0) + 1
        val left = dfs(root.left, local)
        val right = dfs(root.right, local)
        map[local] = map[local]!! - 1

        return count + left + right
    }
}