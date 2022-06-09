package middle

import common.ListNode

object OddEvenList_328 {
    fun oddEvenList(head: ListNode?): ListNode? {
        if(head?.next==null) return head
        val oddHead = ListNode(0)
        var oddCur = oddHead
        val evenHead = ListNode(0)
        var evenCur = evenHead

        var index = 1
        var h = head
        while (h != null) {
            if (index % 2 == 1) {
                oddCur.next = h
                oddCur = oddCur.next!!
            } else {
                evenCur.next = h
                evenCur = evenCur.next!!
            }
            index++
            h = h.next
            oddCur.next = null
            evenCur.next = null
        }
        oddCur.next = evenHead.next
        return oddHead.next
    }
}