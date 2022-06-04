package jzof

import common.ListNode

object JZ52 {
    fun FindFirstCommonNode(pHead1: ListNode?, pHead2: ListNode?): ListNode? {
        val l1 = pHead1?.let { getLen(it) } ?: 0
        val l2 = pHead2?.let { getLen(it) } ?: 0
        if (l1 == 0 || l2 == 0) return null
        var p1 = if (l1 > l2) walk(pHead1, l1 - l2) else pHead1
        var p2 = if (l2 > l1) walk(pHead2, l2 - l1) else pHead2
        while (p1 != p2) {
            p1 = p1!!.next
            p2 = p2!!.next
        }
        return p1

    }

    fun walk(p: ListNode?, step: Int): ListNode? {
        var np = p
        for (i in 1..step) {
            np = np!!.next
        }
        return np
    }

    fun getLen(p: ListNode): Int {
        var pn: ListNode? = p
        var len = 1
        while (pn != null) {
            pn = pn.next
            len++
        }
        return len
    }
}