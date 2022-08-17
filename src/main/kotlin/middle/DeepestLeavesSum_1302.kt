package middle

import common.TreeNode
import common.buildTreeNode
import common.printSelf
import java.util.*

object DeepestLeavesSum_1302 {
    fun deepestLeavesSum(root: TreeNode?): Int {
        val sentry = TreeNode(-1)
        if (root == null)
            return 0
        val queue = LinkedList<TreeNode>()
        queue.add(root)
        queue.add(sentry)
        var result = 0
        while (queue.isNotEmpty()) {
            val next = queue.poll()
            val value = next.`val`
            if (value > 0) {
                result += value
                next.right?.let(queue::add)
                next.left?.let(queue::add)
            } else {// 遇到哨兵
                if (queue.isNotEmpty()) {
                    result = 0
                    queue.add(sentry)
                } else {
                    // do nothing
                }
            }
        }
        return result
    }
}

fun main() {
    val root = buildTreeNode(listOf(6,7,8,2,7,1,3,9,null,1,4,null,null,null,5))
    val result = DeepestLeavesSum_1302.deepestLeavesSum(root)
    result.printSelf()

}