package middle

import common.TreeNode

object GenerateTrees_95 {
    fun generateTrees(n: Int): List<TreeNode?> {
        val dp = Array(n + 1) { mutableListOf<TreeNode?>() }
        dp[0].add(null)
        for (i in 1..n) {
            // 计算 1 to i的子树
            for (j in 1..i) {
                val lefts = get(dp, 1, j - 1)
                val rights = get(dp, j + 1, i)
                for (left in lefts) {
                    for (right in rights) {
                        val r = TreeNode(j)
                        r.left = left
                        r.right = right
                        dp[i].add(r)
                    }
                }
            }
        }
        return dp[n]
    }

    fun get(dp: Array<MutableList<TreeNode?>>, left: Int, right: Int): List<TreeNode?> {
        return if (left > right) listOf(null)
        else if (left == right) {
            listOf(TreeNode(left))
        } else if (left == 1) {
            dp[right]
        } else {
            val up = right - left + 1
            dp[up].map { copyWithPlus(it, left - 1) }
        }
    }


    fun copyWithPlus(root: TreeNode?, p: Int): TreeNode? {
        if (root == null) return root
        val nr = TreeNode(root.`val` + p)
        nr.left = copyWithPlus(root.left, p)
        nr.right = copyWithPlus(root.right, p)
        return nr
    }
}