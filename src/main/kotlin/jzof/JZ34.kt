package jzof

import common.TreeNode

object JZ34 {
    fun FindPath(root: TreeNode?, expectNumber: Int): Array<IntArray> {
        // write code here
        if (root == null) {
            return arrayOf()
        }
        help(root, expectNumber, 0, mutableListOf())
        return result.toTypedArray()
    }

    val result = mutableListOf<IntArray>()

    fun help(root: TreeNode?, tgt: Int, tmp: Int, tmpArray: MutableList<Int>) {
        if (root == null) {
            return
        }

        val local = tmp + root.`val`
        tmpArray.add(root.`val`)

        if (local == tgt && root.left == null && root.right == null) {
            result.add(tmpArray.toIntArray())
        }
        help(root.left, tgt, local, tmpArray)
        help(root.right, tgt, local, tmpArray)
        tmpArray.removeLast()
    }
}