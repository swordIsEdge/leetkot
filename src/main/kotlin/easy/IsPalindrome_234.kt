package easy

import common.ListNode
import java.util.*

object IsPalindrome_234 {
    fun isPalindrome(head: ListNode?): Boolean {
        if (head == null) return false
        var fast = head!!
        var slow = head
        val stack = LinkedList<Int>()
        while (fast.next != null) {
            fast = fast.next!!
            stack.push(slow!!.`val`)
            if (fast.next != null) {
                slow = slow.next!!
                fast = fast.next!!
            }
        }
        slow = slow!!.next
        while (stack.isNotEmpty() && slow != null) {
            if (stack.peek() != slow.`val`) {
                return false
            }
            stack.pop()
            slow = slow.next
        }
        return true
    }
}