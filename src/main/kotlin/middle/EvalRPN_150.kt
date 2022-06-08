package middle

import java.util.*

object EvalRPN_150 {
    fun evalRPN(tokens: Array<String>): Int {
        if (tokens.isEmpty()) return 0
        val stack = LinkedList<Int>()
        for (token in tokens) {
            when (token) {
                "+" -> {
                    stack.push(stack.pop() + stack.pop())
                }
                "-" -> {
                    stack.push(-stack.pop() + stack.pop())
                }
                "*" -> {
                    stack.push(stack.pop() * stack.pop())
                }
                "/" -> {
                    val b = stack.pop()
                    val a = stack.pop()
                    stack.push(a / b)
                }
                else -> {
                    stack.push(token.toInt())
                }
            }
        }
        return stack.pop().toInt()
    }
}