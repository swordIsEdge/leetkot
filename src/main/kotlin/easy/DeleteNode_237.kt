package easy

import common.ListNode

object DeleteNode_237 {
    fun deleteNode(node: ListNode?) {
        val next= node!!.next
        node.`val` = next?.`val`!!
        node.next = next.next
    }
}