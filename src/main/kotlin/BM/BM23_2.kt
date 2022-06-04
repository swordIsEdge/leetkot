package BM

import common.TreeNode
import common.buildTreeNode
import java.util.*

object BM23_2 {
    fun preorderTraversal(root: TreeNode?): IntArray {
        if (root == null) return IntArray(0)
        val result = mutableListOf<Int>()

        val stack = LinkedList<TreeNode>()
        var tmp = root
        while (stack.isNotEmpty() || tmp != null) {
            tmp = if (tmp != null) {
                stack.push(tmp)
                result.add(tmp.`val`)
                tmp.left
            } else {
                stack.pop().right
            }
        }
        return result.toIntArray()
    }

    fun preorderTraversal2(root: TreeNode?): IntArray {
        val result = mutableListOf<Int>()
        val stack = LinkedList<TreeNode>()
        stack.push(root)

        while (stack.isNotEmpty()) {
            val local = stack.pop()
            if (local != null) {
                result.add(local.`val`)
                stack.push(local.right)
                stack.push(local.left)
            }
        }
        return result.toIntArray()
    }
}

fun main() {
    val root = buildTreeNode(listOf(1, null, 2, 3))
    val res = BM23_2.preorderTraversal2(root)
    for (re in res) {
        print("$re->")
    }
}