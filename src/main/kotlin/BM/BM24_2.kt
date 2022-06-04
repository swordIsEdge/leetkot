package BM

import common.TreeNode
import common.buildTreeNode
import java.util.*

object BM24_2 {
    fun inorderTraversal(root: TreeNode?): IntArray  {
        val stack = LinkedList<TreeNode?>()
        val result = mutableListOf<Int>()
        stack.push(root)
        while (stack.isNotEmpty()) {
            val local = stack.pop()
            if (local != null) {
                if (stack.isNotEmpty() && stack.peek() == local) {
                    result.add(local.`val`)
                    stack.pop()
                } else {
                    stack.push(local.right)
                    stack.push(local)
                    stack.push(local)
                    stack.push(local.left)
                }
            }
        }
        return result.toIntArray()
    }
}
fun main() {
    val root = buildTreeNode(listOf(1, null, 2, 3))
    val res = BM24_2.inorderTraversal(root)
    for (re in res) {
        print("$re->")
    }
}