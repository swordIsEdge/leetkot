package jzof

import common.ListNode
import common.buildListNode
import common.printList

object JZ18 {
    fun deleteNode(head: ListNode?, `val`: Int): ListNode? {
        // write code here
        if (head?.`val` == `val`) {
            return head.next
        }
        var tmp = head
        while (tmp != null) {
            if (tmp.next?.`val` == `val`) {
                tmp.next = tmp.next?.next
            }
            tmp = tmp.next
        }
        return head

    }
}

fun main() {
    val res = JZ18.deleteNode(buildListNode(intArrayOf(1,2,3)),2)
    res.printList()
}