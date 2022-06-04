package jzof

import common.ListNode

object JZ6 {
    fun printListFromTailToHead(head: ListNode?): IntArray  {
        // write code here
        val result = mutableListOf<Int>()
        var head = head
        while (head != null) {
            result.add(0, head.`val`)
            head = head.next

        }
        return result.toIntArray()
    }
}