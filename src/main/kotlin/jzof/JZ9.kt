package jzof

import java.util.*

object JZ9 {
    val stack = Stack<Int>()
    val stack2 = Stack<Int>()
    fun push(node: Int) {
        // write code here
        stack.push(node)
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param 无
     * @return int整型
     */
    fun pop(): Int {
        // write code here
        if (stack.isEmpty() && stack2.isEmpty()) {
            return 0
        }
        if (stack2.isEmpty()) {
            while (!stack.isEmpty()) {
                stack2.push(stack.pop())
            }
        }
        return stack2.pop()

    }
}