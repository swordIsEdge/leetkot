package easy

import common.TreeNode
import common.buildTreeNode
import java.util.*

object InorderTraversal_94 {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) return listOf()
        val stack = LinkedList<TreeNode>()
        val result = mutableListOf<Int>()
        stack.push(root)
        while (stack.isNotEmpty()) {
            val tmp = stack.pop()
            if (stack.isNotEmpty() && stack.peek() == tmp) {
                stack.pop()
                result.add(tmp.`val`)
            } else {
                tmp.right?.let { stack.push(it) }
                stack.push(tmp)
                stack.push(tmp)
                tmp.left?.let { stack.push(it) }
            }
        }
        return result
    }
}

fun main() {
    val t = buildTreeNode(listOf(1, null, 2, 3))
    val r = InorderTraversal_94.inorderTraversal(t)
    for (i in r) {
        println(i)
    }
}