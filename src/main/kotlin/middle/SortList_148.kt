package middle

import common.ListNode
import common.buildListNode
import common.printList


object SortList_148 {
    fun sortList(head: ListNode?): ListNode? {
        if (head == null) return head
        var node = head
        var length = 0
        while (node != null) {
            length++
            node = node.next
        }

        val dummyHead = ListNode(0)
        dummyHead.next = head

        var subLength = 1
        while (subLength < length) {
            var prev = dummyHead
            var curr = dummyHead.next

            while (curr != null) {
                var head1 = curr

                var i = 1
                while (i < subLength && curr!!.next != null) {
                    curr = curr!!.next
                    i++
                }
                var head2 = curr!!.next
                curr.next = null
                curr = head2
                i = 1
                while (i < subLength && curr != null && curr.next != null) {
                    curr = curr!!.next
                    i++
                }
                var next: ListNode? = null
                if (curr != null) {
                    next = curr.next
                    curr.next = null
                }
                val merged = merge(head1, head2)
                prev.next = merged
                while (prev.next != null) {
                    prev = prev.next!!
                }
                curr = next
            }


            subLength = subLength shl 1
        }
        return dummyHead.next
    }

    fun merge(head1: ListNode?, head2: ListNode?): ListNode? {
        val dummyHead = ListNode(0)
        var temp: ListNode = dummyHead
        var temp1: ListNode? = head1
        var temp2: ListNode? = head2
        while (temp1 != null && temp2 != null) {
            if (temp1.`val` <= temp2.`val`) {
                temp.next = temp1
                temp1 = temp1.next
            } else {
                temp.next = temp2
                temp2 = temp2.next
            }
            temp = temp.next!!
        }

        if (temp1 != null) {
            temp.next = temp1
        } else if (temp2 != null) {
            temp.next = temp2
        }

        return dummyHead.next
    }
}

fun main() {
    val root = buildListNode(intArrayOf(2,1,0))
    val result = SortList_148.sortList(root)
   result.printList()
}


// 快排链表
//
//internal class Solution {
//    fun sortList(head: ListNode?): ListNode? {
//        if (head == null || head.next == null) return head
//        // 没有条件，创造条件。自己添加头节点，最后返回时去掉即可。
//        val newHead = ListNode(-1)
//        newHead.next = head
//        return quickSort(newHead, null)
//    }
//
//    // 带头结点的链表快速排序
//    private fun quickSort(head: ListNode?, end: ListNode?): ListNode? {
//        if (head == end || head!!.next == end || head!!.next!!.next == end) return head
//        // 将小于划分点的值存储在临时链表中
//        val tmpHead = ListNode(-1)
//        // partition为划分点，p为链表指针，tp为临时链表指针
//        val partition = head!!.next
//        var p = partition
//        var tp: ListNode? = tmpHead
//        // 将小于划分点的结点放到临时链表中
//        while (p!!.next != end) {
//            if (p.next!!.`val` < partition!!.`val`) {
//                tp!!.next = p.next
//                tp = tp.next
//                p.next = p.next!!.next
//            } else {
//                p = p.next
//            }
//        }
//        // 合并临时链表和原链表，将原链表接到临时链表后面即可
//        tp!!.next = head.next
//        // 将临时链表插回原链表，注意是插回！（不做这一步在对右半部分处理时就断链了）
//        head.next = tmpHead.next
//        quickSort(head, partition)
//        quickSort(partition, end)
//        // 题目要求不带头节点，返回结果时去除
//        return head.next
//    }
//}