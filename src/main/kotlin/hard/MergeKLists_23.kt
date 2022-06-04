package hard

import common.ListNode
import java.util.*

class MergeKLists_23 {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val heap = PriorityQueue<ListNode> { nodeA, nodeB -> nodeA.`val` - nodeB.`val` }
        lists.filterNotNull().forEach { heap.add(it) }
        val preHead = ListNode(0)
        var tmp = preHead
        while (heap.isNotEmpty()) {
            val head = heap.poll()
            tmp.next = ListNode(head.`val`)
            tmp = tmp.next!!
            head.next?.let { heap.add(it) }
        }
        return preHead.next
    }

}
