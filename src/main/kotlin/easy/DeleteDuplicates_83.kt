package easy

import common.ListNode

object DeleteDuplicates_83 {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        val preHead = ListNode(-200)
        var last = preHead
        var temp = head

        while (temp != null) {
            if (temp.`val` != last.`val`) {
                last.next = temp
                last = last.next!!
            }
            temp = temp.next
        }
        last.next = null
        return preHead.next
    }
}