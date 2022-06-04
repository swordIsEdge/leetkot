package jzof

import common.ListNode
import common.buildListNode
import common.printList

object JZ76 {
    fun deleteDuplication(pHead: ListNode?): ListNode? {
        // write code here
        val preHead = ListNode(0)
        preHead.next = pHead
        var last: ListNode? = preHead
        while (last?.next != null) {
            if (last.next?.`val` == last.next?.next?.`val`) {
                var tmp = last.next
                while (tmp?.`val` == tmp?.next?.`val`) {
                    tmp = tmp?.next
                }
                last.next = tmp?.next
            } else {
                last = last.next

            }
        }
       return preHead.next
    }

}

fun main() {
    val ln = buildListNode(intArrayOf(1, 2, 3, 3, 4, 4, 5))
    val res = JZ76.deleteDuplication(ln)
    res.printList()

}