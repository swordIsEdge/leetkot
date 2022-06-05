package middle

import common.ListNode

object RemoveNthFromEnd_19 {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if (head == null) return head
        var preHead = ListNode(1)
        preHead.next = head
        var fast: ListNode? = preHead
        var slow = preHead
        for (i in 1..n) {
            fast = fast?.next
        }
        if (fast == null) {
            return head
        }
        while (fast!!.next != null) {
            fast = fast.next
            slow = slow.next!!
        }
        slow.next = slow.next?.next
        return preHead.next
    }
}