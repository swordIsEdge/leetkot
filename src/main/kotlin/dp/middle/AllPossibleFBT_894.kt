package dp.middle

import common.TreeNode

object AllPossibleFBT_894 {
    val cache = hashMapOf<Int, List<TreeNode?>>()
    fun allPossibleFBT(n: Int): List<TreeNode?> {
        if (n in cache) {
            return cache[n]!!
        }
        val res = when (n) {
            1 -> listOf(TreeNode(0))
            2 -> listOf()
            else -> {
                val result = mutableListOf<TreeNode?>()
                for (i in 1 until n - 1) {
                    val lefts = allPossibleFBT(i).filterNotNull()
                    val rights = allPossibleFBT(n - 1 - i).filterNotNull()
                    if (lefts.isEmpty() || rights.isEmpty()) {
                        continue
                    }
                    for (left in lefts) {
                        for (right in rights) {
                            val root = TreeNode(0)
                            root.left = left
                            root.right = right
                            result.add(root)
                        }
                    }
                }
                result
            }
        }
        cache[n] = res
        return res
    }
}