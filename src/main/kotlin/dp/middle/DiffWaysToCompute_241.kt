package dp.middle

object DiffWaysToCompute_241 {
    fun diffWaysToCompute(expression: String): List<Int> {
        val items = mutableListOf<Item>()
        var last = 0
        for (c in expression) {
            when (c) {
                '+', '-', '*' -> {
                    items.add(Item.Num(last))
                    last = 0
                    items.add(Item.Sign(c))
                }
                else -> {
                    last = last * 10 + (c - '0')
                }
            }
        }
        items.add(Item.Num(last))
        return compute(items)
    }

    fun compute(items: List<Item>): List<Int> {
        return if (items.isEmpty()) listOf()
        else if (items.size == 1) {
            when (val item = items[0]) {
                is Item.Num -> listOf(item.num)
                else -> listOf()
            }
        } else {
            val result = mutableListOf<Int>()
            for (i in items.indices) {
                val item = items[i]
                if (item is Item.Num) {
                    continue
                } else {
                    val left = compute(items.subList(0, i))
                    val right = compute(items.subList(i + 1, items.size))
                    val c: Char = (item as Item.Sign).c
                    for (le in left) {
                        for (ri in right) {
                            when (c) {
                                '+' -> result.add(le + ri)
                                '-' -> result.add(le - ri)
                                '*' -> result.add(le * ri)
                            }
                        }
                    }
                }
            }
            result
        }
    }

    sealed class Item {
        class Num(val num: Int) : Item()
        class Sign(val c: Char) : Item()
    }
}