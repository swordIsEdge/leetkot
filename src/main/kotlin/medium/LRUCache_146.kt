package medium

class LRUCache_146(capacity: Int) {
    val capacity = capacity
    val map = hashMapOf<Int, Node>()
    var size = 0
    fun get(key: Int): Int {
        if (map.containsKey(key)) {
            lift(key)
            return map[key]!!.value
        } else {
            return -1
        }
    }

    fun put(key: Int, value: Int) {
        if (map.containsKey(key)) {
            map[key]!!.value = value
            lift(key)
        } else {
            size++
            map[key] = addNew(key, value)
            while (size > this.capacity) {
                removeLast()
                size--
            }
        }

    }

    var lst: Node? = null
    var hed: Node? = null

    fun lift(key: Int) {
        val node = map[key]
        if (hed == node) return
        if (lst == node) {
            lst = node!!.pre
            lst!!.next = null

            node.pre = null
            node.next = hed
            hed!!.pre = node

            hed = node
        } else {
            node!!.next!!.pre = node.pre
            node.pre!!.next = node.next

            node.pre = null
            node.next = hed
            hed!!.pre = node

            hed = node
        }
    }

    fun removeLast() {
        if (lst != null) {
            map.remove(lst!!.key)
            lst = lst!!.pre
        }
        if (lst == null) {
            hed = null
        }
    }

    fun addNew(key: Int, value: Int): Node {
        val node = Node(key, value, null, null)
        if (lst == null) {
            lst = node
        }
        if (hed == null) {
            hed = node
        } else {
            node.next = hed
            hed!!.pre = node
            hed = node
        }
        return node
    }

    class Node(
        val key: Int,
        var value: Int,
        var pre: Node?,
        var next: Node?
    ) {
    }
}

fun main() {
    val L = LRUCache_146(2)
    L.put(1,1)
    println("A")
    L.put(2,2)
    println("A")

    L.get(2)
    println("B")
    L.put(3,3)
    L.get(2)
    L.put(4,4)
    L.get(1)
    L.get(3)
    L.get(4)
}