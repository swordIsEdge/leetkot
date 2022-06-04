package BM

import common.TreeNode
import common.buildTreeNode
import java.util.*

object BM25_2 {
    fun postorderTraversal(root: TreeNode?): IntArray {
        val stack = LinkedList<TreeNode?>()
        val result = mutableListOf<Int>()
        stack.push(root)
        while (stack.isNotEmpty()) {
            val tmp = stack.pop()
            if (tmp != null) {
                if (stack.isNotEmpty() && stack.peek()==tmp) {
                    result.add(tmp.`val`)
                    stack.pop()
                } else {
                    stack.push(tmp)
                    stack.push(tmp)
                    stack.push(tmp.right)
                    stack.push(tmp.left)
                }
            }
        }
        return result.toIntArray()
    }
}fun main() {
    val root = buildTreeNode(listOf(1, null, 2, 3))
    val res = BM25_2.postorderTraversal(root)
    for (re in res) {
        print("$re->")
    }
}