package middle

import java.util.*

object ValidateStackSequences {
    fun validateStackSequences(pushed: IntArray, popped: IntArray): Boolean {
        val stack = LinkedList<Int>()
        var index = 0
        for (i in pushed) {
            stack.push(i)
            while (stack.isNotEmpty() && stack.peek() == popped[index]) {
                index++
                stack.pop()
            }
        }
        return stack.isEmpty()
    }
}