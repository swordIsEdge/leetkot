package jzof

import common.ListNode

object JZ23 {
    fun EntryNodeOfLoop(pHead: ListNode?): ListNode? {
        // write code here
        if (pHead == null) return null
        var fast = pHead
        var slow = pHead
        while (fast != null && fast.next != null) {
            fast = fast.next!!.next
            slow = slow!!.next
            if (fast == slow) {
                break
            }
        }
        if (fast?.next == null) {
            return null
        }
        fast = pHead
        while (fast != slow) {
            fast =fast!!.next
            slow=slow!!.next
        }
        return fast


    }
}