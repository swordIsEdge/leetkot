package medium

import common.ListNode

object RotateRight {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if (head?.next == null) {
            return head
        }
        var len = 1
        var tmp = head
        while (tmp!!.next != null) {
            tmp = tmp.next!!
            len++
        }
        val newK = k % len
        if(newK==0) return head

        val step = len-newK
        tmp = head
        var s = 1
        while (s < step) {
            s++
            tmp = tmp!!.next
        }
        val next= tmp!!.next
        tmp.next = null

        tmp = next
        while (tmp!!.next != null) {
            tmp = tmp.next!!
        }
        tmp.next = head
        return next
    }
}