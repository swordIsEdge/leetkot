package easy

import common.ListNode

object GetIntersectionNode_160 {
    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        if (headA == null || headB == null) return null
        var tailA = headA!!
        var lenA = 1
        var tailB = headB!!
        var lenB = 1
        while (tailA.next != null) {
            tailA = tailA.next!!
            lenA++
        }
        while (tailB.next != null) {
            lenB++
            tailB = tailB.next!!
        }

        if (tailA != tailB) {
            return null
        }
        tailA = headA!!
        tailB = headB!!
        for(i in 1..(lenA-lenB)){
            tailA = tailA.next!!
        }
        for(i in 1..(lenB-lenA)){
            tailB = tailB.next!!
        }
        while (tailA != tailB) {
            tailA =tailA.next!!
            tailB = tailB.next!!
        }
        return tailA


    }
}