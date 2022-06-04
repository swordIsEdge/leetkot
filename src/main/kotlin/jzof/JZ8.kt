package jzof

class TreeLinkNode(var `val`: Int) {
    var left: TreeLinkNode? = null
    var right: TreeLinkNode? = null
    var next: TreeLinkNode? = null
}

object JZ8 {
    fun GetNext(pNode: TreeLinkNode?): TreeLinkNode? {
        // write code here
        if (pNode == null) {
            return pNode
        }
        if (pNode.right != null) {
            var tmp = pNode.right!!
            while (tmp.left != null) {
                tmp = tmp.left!!
            }
            return tmp
        } else if (pNode.next == null) {
            return null
        } else if (pNode.next!!.left == pNode) {
            return pNode.next
        } else {
            var pre = pNode.next!!
            while (true) {
                if (pre.next == null) {
                    return null
                } else if (pre.next!!.left == pre) {
                    return pre.next
                } else {
                    pre = pre.next!!
                }
            }
        }
    }
}