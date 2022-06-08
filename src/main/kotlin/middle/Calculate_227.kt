package middle

import java.util.*

object Calculate_227 {
    fun calculate(s: String): Int {
        val items = mutableListOf<Item_2>()
        var last = 0
        for (c in s) {
            if (c == ' ') continue
            when (c) {
                '+', '-', '*', '/' -> {
                    items.add(Item_2.Num(last))
                    last = 0
                    items.add(Item_2.Sign(c))
                }
                else -> {
                    last = last * 10 + (c - '0')
                }
            }
        }
        items.add(Item_2.Num(last))

        val list = LinkedList<Item_2>()
        var index = 0
        while (index < items.size) {
            val item = items[index++]
            if (item is Item_2.Num) {
                list.push(item)
            } else {
                when ((item as Item_2.Sign).c) {
                    '+' -> list.push(item)
                    '-' -> list.push(item)
                    '*' -> {
                        val a = (list.pop() as Item_2.Num).num
                        val b = (items[index++] as Item_2.Num).num
                        list.push(Item_2.Num(a * b))
                    }
                    '/' -> {
                        val a = (list.pop() as Item_2.Num).num
                        val b = (items[index++] as Item_2.Num).num
                        list.push(Item_2.Num(a / b))
                    }

                }
            }
        }
        val stack = LinkedList<Item_2>()

        while (list.isNotEmpty()) {
            val item = list.removeLast()
            if (item is Item_2.Num) {
                stack.push(item)
            } else {
                val a = (stack.pop() as Item_2.Num).num
                val b = (list.removeLast() as Item_2.Num).num
                when ((item as Item_2.Sign).c) {
                    '+' -> stack.push(Item_2.Num(a + b))

                    '-' -> stack.push(Item_2.Num(a-b))
                }
            }
        }
        return (stack.pop() as Item_2.Num).num
    }

    sealed class Item_2 {
        class Num(val num: Int) : Item_2()
        class Sign(val c: Char) : Item_2()
    }
}

fun main() {
    Calculate_227.calculate("0-1234")
}