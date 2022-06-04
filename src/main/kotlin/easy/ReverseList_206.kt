package easy

import common.ListNode

object ReverseList_206 {
    fun reverseList(head: ListNode?): ListNode? {
        if (head==null) return null
        var last = head!!
        var next = head.next
        last.next = null

        while (next != null) {
            val tmp = next
            next = next.next
            tmp.next = last
            last = tmp
        }
        return last

    }
}