package medium

import common.ListNode

object DetectCycle_142 {
    fun detectCycle(head: ListNode?): ListNode? {
        if (head == null) return head
        var fast = head
        var slow = head
        while (fast != null) {
            fast = fast.next?.next
            slow = slow!!.next
            if (fast == slow) {
                break
            }
        }
        if (fast == null) return null
        fast = head
        while (fast != slow) {
            fast = fast!!.next
            slow = slow!!.next
        }
        return fast

    }
}