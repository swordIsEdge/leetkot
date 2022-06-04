package medium

import common.ListNode
import common.buildListNode
import common.printList


object SortList_148_2 {


    fun sortList(head: ListNode?): ListNode? {
        if (head == null) return null
        var tmp = head
        var len = 0
        while (tmp != null) {
            len++
            tmp = tmp.next
        }
        val preHead = ListNode(0)
        preHead.next = head

        var subLen = 1
        while (subLen < len) {
            var pre = preHead
            var cur = pre.next
            while (cur != null) {
                val head1 = cur
                for (i in 1 until subLen) {
                    if (cur==null) break
                    cur = cur.next
                }

                val head2 = cur?.next
                cur?.next = null
                cur = head2

                for (i in 1 until subLen) {
                    if (cur==null) break
                    cur = cur.next
                }

                val next = cur?.next
                cur?.next = null

                val merged = merge(head1,head2)
                pre.next = merged
                while (pre.next != null) {
                    pre = pre.next!!
                }
                cur = next


            }
            subLen = subLen shl 1
        }
        return preHead.next
    }


    fun merge(head1: ListNode?, head2: ListNode?): ListNode? {
        val preHead = ListNode(0)
        var tmp = preHead
        var tmp1 = head1
        var tmp2 = head2
        while (tmp1 != null && tmp2 != null) {
            if (tmp1.`val` < tmp2.`val`) {
                tmp.next = ListNode(tmp1.`val`)
                tmp1 = tmp1.next
            } else {
                tmp.next = ListNode(tmp2.`val`)
                tmp2 = tmp2.next
            }
            tmp = tmp.next!!
        }
        if (tmp1 != null) {
            tmp.next = tmp1
        } else if (tmp2 != null) {
            tmp.next = tmp2
        }

        return preHead.next

    }
}

fun main() {
    val root = buildListNode(intArrayOf(2, 1, 0))
    val result = SortList_148_2.sortList(root)
   result.printList()
}

