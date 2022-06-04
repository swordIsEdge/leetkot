package jzof

import java.util.*

object JZ41 {
    var total = 0
    val up = PriorityQueue<Int>() // 小根堆
    val down = PriorityQueue<Int> { i, j -> j.compareTo(i) } // 大根堆

    fun Insert(num: Int) {
        // write code here
        total++
        down.add(num)
        up.add(down.poll())

        if (total % 2 == 0) {
            down.add(up.poll())
        }
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param 无
     * @return double浮点型
     */
    fun GetMedian(): Double {
        // write code here
        return if (total == 0) 0.0
        else if (total % 2 == 1) {
            up.peek() *1.0
        } else {
            (up.peek() + down.peek()) * 1.0 / 2
        }
    }
}

fun main() {
    val source = arrayOf(5, 2, 3, 4, 1, 6, 7, 0, 8)
    for (s in source) {
        JZ41.Insert(s)
        val r = JZ41.GetMedian()
        println(r)
    }
}