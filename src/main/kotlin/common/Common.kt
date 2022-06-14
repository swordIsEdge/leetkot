@file:Suppress("NAME_SHADOWING")

package common

import java.util.*

class Common {
}

class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
    override fun toString(): String {
        return `val`.toString()
    }
}

class RandomListNode(var label: Int) {
    var next: RandomListNode? = null
    var random: RandomListNode? = null
}

fun buildListNode(keys: IntArray): ListNode? {
    val head = ListNode(0)
    var tmp = head
    for (key in keys) {
        tmp.next = ListNode(key)
        tmp = tmp.next!!
    }
    return head.next
}

fun ListNode?.printList() {
    var tmp: ListNode? = this
    var lines = ""
    while (tmp != null) {
        lines += tmp.`val`
        tmp = tmp.next
        if (tmp != null) {
            lines += "-->"
        }
    }
    println(lines)
}


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun buildTreeNode(keys: List<Int?>): TreeNode {
    val queue = LinkedList<TreeNode>()
    val root = TreeNode(keys[0]!!)
    queue.add(root)
    var i = 1
    while (queue.isNotEmpty() && i < keys.size) {
        val left = keys[i++]
        if (left != null) {
            val lNode = TreeNode(left)
            queue.peek().left = lNode
            queue.add(lNode)
        }
        if (i >= keys.size) {
            break
        }
        val right = keys[i++]
        if (right != null) {
            val rNode = TreeNode(right)
            queue.peek().right = rNode
            queue.add(rNode)
        }
        queue.poll()
    }
    return root
}

fun IntArray.printSelf() {
    for (i in this) {
        print("$i->")
    }
    println()
}

fun BooleanArray.printSelf() {
    for (i in this) {
        print("$i->")
    }
    println()
}

fun List<Int>.printSelf() {
    for (i in this) {
        print("$i->")
    }
    println()
}

fun Set<Int>.printSelf() {
    val s = "{" + this.map { it.toString() }.joinToString(separator = ",") + "}"
    println(s)
}

fun Int.repeat(i: Int): IntArray {
    return IntArray(i) { this }
}

fun parserIntArray(s: String): IntArray {
    var s = s
    if (s.startsWith('[')) s = s.substring(1)
    if (s.endsWith(']')) s = s.substring(0, s.length - 1)
    val items = s.split(',')
    return items.map { it.toInt() }.toIntArray()
}

fun parserArrayIntArray(s: String): Array<IntArray> {
    var s = s
    if (s.startsWith('[')) s = s.substring(1)
    if (s.endsWith(']')) s = s.substring(0, s.length - 1)
    val items = s.split("],")
    return items.map { parserIntArray(it) }.toTypedArray()
}
fun Any.printSelf() {
    println(this)
}

fun main() {
    val r = buildTreeNode(listOf(1, null, 2, 3))
    println(r.`val`)
}