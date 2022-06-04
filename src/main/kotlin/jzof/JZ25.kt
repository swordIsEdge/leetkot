package jzof

import common.ListNode

object JZ25 {
    fun Merge(pHead1: ListNode?, pHead2: ListNode?): ListNode? {
        // write code here
        val preHead = ListNode(0)
        var tmp = preHead
        var h1 = pHead1
        var h2 = pHead2
        while (h1 != null || h2 != null) {
            if (h1 == null) {
                tmp.next = ListNode(h2!!.`val`)
                h2 = h2.next
            } else if (h2 == null) {
                tmp.next = ListNode(h1.`val`)
                h1 = h1.next
            } else {
                val v1 = h1.`val`
                val v2 = h2.`val`
                if (v1 >= v2) {
                    h2 = h2.next
                } else {
                    h1 = h1.next
                }
                tmp.next = ListNode(minOf(v1,v2))
            }
            tmp = tmp.next!!
        }

        return preHead.next
    }


}