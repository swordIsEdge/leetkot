package jzof

import common.TreeNode
import java.util.*

object JZ37 {
    fun Serialize(root: TreeNode?): String {
        // write code here
        if (root == null) {
            return ""
        }
        val array = mutableListOf<Int?>()
        val queue = LinkedList<TreeNode?>()
        queue.add(root)
        while (queue.isNotEmpty()) {
            val node = queue.poll()
            array.add(node?.`val`)
            if (node != null) {
                queue.add(node.left)
                queue.add(node.right)
            }
        }
        return array.joinToString(separator = ",") { it?.toString() ?: "#" }
    }

    fun Deserialize(str: String): TreeNode? {
        if (str.isBlank()) {
            return null
        }
        val keys = str.split(",")
        if (keys.isEmpty()) {
            return null
        }

        val queue = LinkedList<TreeNode>()
        val root = TreeNode(keys[0].toInt())
        queue.add(root)
        var i = 1
        while (queue.isNotEmpty() && i < keys.size) {
            val left = keys[i++]
            if (left != "#") {
                val lNode = TreeNode(left.toInt())
                queue.peek().left = lNode
                queue.add(lNode)
            }
            if (i >= keys.size) {
                break
            }
            val right = keys[i++]
            if (right != "#") {
                val rNode = TreeNode(right.toInt())
                queue.peek().right = rNode
                queue.add(rNode)
            }
            queue.poll()
        }
        return root
    }
}

fun main() {
    val result = JZ37.Deserialize("1,2,3,#,#,6,7")
    val result2 = JZ37.Serialize(result)
    print(result2)

}