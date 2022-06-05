package middle

import common.ListNode

private class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        return addTwoNumbers(l1, l2, 0)
    }

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?, p: Int): ListNode? {
        val f = l1?.`val` ?: 0
        val s = l2?.`val` ?: 0
        val r = f + s + p
        return if (r == 0 && l1 == null && l2 == null) {
            null
        } else {
            val result = ListNode(r % 10)
            result.next = addTwoNumbers(l1?.next, l2?.next, r / 10)
            result
        }
    }

    fun addTwoNumbers2(l1: ListNode?, l2: ListNode?): ListNode? {
        return add(l1, l2, 0)
    }

    fun add(l1: ListNode?, l2: ListNode?, carry: Int): ListNode? {
        val tmp = (l1?.`val` ?: 0) +(l2?.`val` ?: 0) + carry
        return if (l1 == null && l2 == null && tmp == 0) {
            null
        } else {
            val next = add(l1?.next, l2?.next, tmp / 10)
            val local = ListNode(tmp % 10)
            local.next = next
            local
        }
    }
}