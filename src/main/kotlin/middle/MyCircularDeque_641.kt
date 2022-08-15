package middle

import common.printSelf

class MyCircularDeque_641(k: Int) {

    val capacity: Int
    var size = 0

    var head: Int
    var tail = 0
    val data: IntArray

    init {
        capacity = k
        head = capacity - 1
        data = IntArray(capacity)
    }

    fun insertFront(value: Int): Boolean {
        return if (isFull()) {
            false
        } else {
            head = (head + 1) % capacity 
            data[head] = value
            size++
            true
        }
    }

    fun insertLast(value: Int): Boolean {
        return if (isFull()) {
            false
        } else {
            tail = (tail + capacity - 1) % capacity 
            data[tail] = value
            size++
            true
        }
    }

    fun deleteFront(): Boolean {
        return if (isEmpty()) {
            false
        } else {
            head = (head + capacity - 1) % capacity 
            size--
            true
        }
    }

    fun deleteLast(): Boolean {
        return if (isEmpty()) {
            false
        } else {
            tail = (tail + 1) % capacity 
            size--
            true
        }
    }

    fun getFront(): Int {
        return if (isEmpty()) -1 else data[head]
    }

    fun getRear(): Int {
        return if (isEmpty()) -1 else data[tail]
    }

    fun isEmpty(): Boolean {
        return size == 0
    }

    fun isFull(): Boolean {
        return size == capacity
    }

}

fun main() {
    val obj = MyCircularDeque_641(3)

    obj.insertLast(1).printSelf()
    obj.insertLast(2).printSelf()
    obj.insertFront(3).printSelf()
    obj.insertFront(4).printSelf()
    obj.getRear().printSelf()
    obj.isFull().printSelf()
    obj.deleteLast().printSelf()
    obj.insertFront(4).printSelf()
    obj.getFront().printSelf()
}