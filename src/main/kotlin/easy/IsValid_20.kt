package easy

import java.util.*

object IsValid_20 {
    fun isValid(s: String): Boolean {
        val stack = LinkedList<Char>()
        for (c in s) {
            when (c) {
                '[', '{', '(' -> stack.push(c)
                ')' -> if (stack.isNotEmpty() && stack.peek()=='(') stack.pop() else return false
                ']' -> if (stack.isNotEmpty() &&  stack.peek()=='[') stack.pop() else return false
                '}' -> if (stack.isNotEmpty() &&  stack.peek()=='{') stack.pop() else return false
            }
        }
        return stack.isEmpty()
    }
}

fun main() {
    val r = IsValid_20.isValid("([)]")
    println(r)
}