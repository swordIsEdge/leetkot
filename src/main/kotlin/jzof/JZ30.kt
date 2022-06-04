package jzof

import java.util.Stack

object JZ30 {
    val stack = Stack<Int>()
    val minStack = Stack<Int>()

    fun push(value: Int) {
        // write code here
        stack.push(value)
        val minValue = if (minStack.isEmpty()) value else minOf(minStack.peek(),value)
        minStack.push(minValue)

    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param 无
     * @return 无
     */
    fun pop() {
        // write code here
        minStack.pop()
        stack.pop()
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param 无
     * @return int整型
     */
    fun top(): Int {
        // write code here
        return stack.peek()
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param 无
     * @return int整型
     */
    fun min(): Int {
        // write code here
        return minStack.peek()
    }
}