package middle

import common.printSelf

class MyCircularQueue_622(k: Int) {
    var last = -1
    var first = 0
    val capacitry: Int
    val data: IntArray
    var size = 0

    init {
        capacitry = k
        data = IntArray(k)
    }

    fun enQueue(value: Int): Boolean {
        return if (isFull()) {
            false
        } else {
            size++
            last = (last + 1) % capacitry
            data[last]= value
            true
        }
    }

    fun deQueue(): Boolean {
        return if (isEmpty()) {
            false
        } else {
            size--
            first = (first + 1) % capacitry
            true
        }
    }

    fun Front(): Int {
        return if (isEmpty()) -1 else data[first]
    }

    fun Rear(): Int {
        return if (isEmpty()) -1 else data[last]
    }

    fun isEmpty(): Boolean {
        return size==0
    }

    fun isFull(): Boolean {
        return size==capacitry
    }
}

fun main() {
    val obj = MyCircularQueue_622(3)
    obj.enQueue(1).printSelf()
    obj.enQueue(2).printSelf()
    obj.enQueue(3).printSelf()
    obj.enQueue(4).printSelf()
    obj.Rear().printSelf()
    obj.isFull().printSelf()
    obj.deQueue().printSelf()
    obj.enQueue(4).printSelf()
    obj.Rear().printSelf()
}