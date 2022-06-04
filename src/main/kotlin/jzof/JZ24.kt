package jzof

import common.ListNode

object JZ24 {
    fun ReverseList(head: ListNode?): ListNode? {
        var nhead:ListNode? = head
        var tmp:ListNode? = null
        while (nhead != null) {
            val last = tmp
            tmp = ListNode(nhead.`val`)
            tmp.next = last
            nhead = nhead.next
        }
        return tmp
    }
}