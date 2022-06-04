package jzof

import common.RandomListNode

object JZ35 {
    fun Clone(pHead: RandomListNode?): RandomListNode? {
        // write code here
        if (pHead == null) {
            return null
        }
        val maps = mutableMapOf<RandomListNode, RandomListNode>()
        var tmp = pHead
        while (tmp != null) {
            val tmpMirror = getMirrorNode(maps, tmp)
            tmpMirror!!.next = getMirrorNode(maps, tmp.next)
            tmpMirror.random = getMirrorNode(maps, tmp.random)
            tmp = tmp.next
        }
        return maps[pHead]
    }

    fun getMirrorNode(maps: MutableMap<RandomListNode, RandomListNode>, node: RandomListNode?) =
        node?.let { maps.getOrPut(node) { RandomListNode(node.label) } }


}