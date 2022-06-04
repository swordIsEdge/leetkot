package jzof

import java.util.*

object JZ75 {
    val queue = LinkedList<Char>()
    val map = IntArray(129) { 0 }

    fun Insert(ch: Char) {
        // write code here
        queue.offer(ch)
        map[ch.code]+=1
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param 无
     * @return char字符型
     */
    fun FirstAppearingOnce(): Char {
        // write code here
        while (queue.isNotEmpty() && map[queue.peek().code] > 1) {
            queue.poll()
        }
        return if (queue.isEmpty()) '#' else queue.peek()
    }
}

fun main() {
    for (c in "google") {
        JZ75.Insert(c)
        print(JZ75.FirstAppearingOnce())
    }
}