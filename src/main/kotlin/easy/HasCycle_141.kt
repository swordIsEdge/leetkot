package easy

import common.ListNode

object HasCycle_141 {
    fun hasCycle(head: ListNode?): Boolean {
        if (head == null) return false
        var fast = head
        var slow = head
        while (fast != null && slow != null) {
            fast = fast.next?.next
            slow = slow.next
            if (fast != null && fast == slow) {
                return true
            }
        }
        return false
    }
}