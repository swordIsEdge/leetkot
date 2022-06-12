package dp.middle

import common.TreeNode
import common.buildTreeNode

object MaxValue_LCP_34 {
    var map = listOf<HashMap<TreeNode, Int>>()
    var max = Int.MIN_VALUE
    fun maxValue(root: TreeNode?, k: Int): Int {
        map = List(k + 1) { HashMap<TreeNode, Int>() }
        cachedDfs(root, k, k)
        return max
    }

    fun cachedDfs(root: TreeNode?, k: Int, remain: Int): Int {
        if (root == null) return 0
        if (map[remain].containsKey(root)) return map[remain][root]!!
        val result = dfs(root, k, remain)
        map[remain][root] = result
        return result
    }

    fun dfs(root: TreeNode, k: Int, remain: Int): Int {
        // root不染色,左右分k
        var tmpMax = cachedDfs(root.left, k, k) + cachedDfs(root.right, k, k)
        // root 染色 左右分 remain - 1 ，需要remain>0
        if (remain > 0) {
            for (i in 0 until remain) {
                val left = cachedDfs(root.left, k, i)
                val right = cachedDfs(root.right, k, remain - 1 - i)
                tmpMax = maxOf(tmpMax, left + right + root.`val`)
            }
        }
        max = maxOf(max, tmpMax)
//        println("root ${root.`val`}  remain $remain max $tmpMax")
        return tmpMax
    }
}

fun main() {
    val root = buildTreeNode(listOf(8, 1, 3, 9, 9, 9, null, 9, 5, 6, 8))
    val result = MaxValue_LCP_34.maxValue(root, 2)
    println(result)
}