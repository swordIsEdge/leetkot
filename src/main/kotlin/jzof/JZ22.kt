package jzof

import common.ListNode
import common.buildListNode
import common.printList

object JZ22 {
    fun FindKthToTail(pHead: ListNode?, k: Int): ListNode? {
        // write code here
        var f = pHead
        var s = pHead
        for(i in 1..k){
            if (f == null) {
                return null
            }
            f = f.next
        }
        while (f != null) {
            s = s!!.next
            f = f.next
        }
        return s
    }
}

fun main() {
    val ln = buildListNode(intArrayOf(0, 2, 3, 4, 5))
    ln.printList()
    val res = JZ22.FindKthToTail(ln, 5)
    res.printList()

}