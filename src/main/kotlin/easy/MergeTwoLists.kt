package easy

import common.ListNode

object MergeTwoLists {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var l1 = list1
        var l2 = list2
        val head = ListNode(-1)
        var tmp = head
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                tmp.next = ListNode(l2!!.`val`)
                l2 = l2.next
            } else if (l2 == null) {
                tmp.next = ListNode(l1.`val`)
                tmp.next = l1
                l1 = l1.next

            } else {
                val v1 = l1.`val`
                val v2 = l2.`val`
                tmp.next = ListNode(minOf(v1, v2))
                if (v1 <= v2) {
                    l1 = l1.next
                } else {
                    l2 = l2.next
                }
            }
            tmp = tmp.next!!

        }
        return head.next
    }
}