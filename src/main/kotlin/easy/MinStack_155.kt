package easy

import java.util.*

object MinStack_155 {
    val stack = LinkedList<Int>()
    val minStack = LinkedList<Int>()
    fun push(`val`: Int) {
        stack.push(`val`)
        val min = if (minStack.isEmpty()) `val` else minOf(`val`, minStack.peek())
        minStack.push(min)
    }

    fun pop() {
        minStack.pop()
        stack.pop()
    }

    fun top(): Int {
        return stack.peek()
    }

    fun getMin(): Int {
        return minStack.peek()
    }
}