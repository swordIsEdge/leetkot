package jzof

import java.util.*

object JZ31 {
    fun IsPopOrder(pushV: IntArray,popV: IntArray): Boolean  {
        // write code here
        val stack = Stack<Int>()
        var popI = 0
        for (i in pushV) {
            stack.push(i)
            while (stack.isNotEmpty() && stack.peek() == popV[popI]) {
                stack.pop()
                popI++
            }

        }
        return stack.isEmpty()
    }
}