package middle

import common.TreeNode
import java.util.*

object Flatten_114 {
    fun flatten(root: TreeNode?): Unit {
        if(root == null) return
        val queue = LinkedList<TreeNode>()
        queue.push(root)
        var pre: TreeNode? = null
        while (queue.isNotEmpty()) {
            val tmp = queue.poll()
            val right = tmp.right
            val left = tmp.left
            left?.let { queue.push(left) }
            right?.let { queue.push(right) }
            tmp.left = null
            if (pre != null) {
                pre.right = tmp
            }
            pre = tmp
        }
    }
}