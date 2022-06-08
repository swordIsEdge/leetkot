package middle

import common.Node

object CopyRandomList_138 {
    fun copyRandomList(node: Node?): Node? {
        if (node == null) return null
        val preHead = Node(0)
        var cur = node
        var tmp = preHead
        val map = hashMapOf<Node, Node>()
        while (cur != null) {
            val curCopy = map.getOrPut(cur) { Node(cur!!.`val`) }
            val cr = cur.random
            curCopy.random = cr?.let { map.getOrPut(it) { Node(it.`val`) } }
            cur = cur.next
            tmp.next = curCopy
            tmp = tmp.next!!
        }
        return preHead.next
    }
}