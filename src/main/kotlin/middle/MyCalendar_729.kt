package middle

import java.util.*

object MyCalendar_729 {


    val exists = mutableListOf<Pair<Int, Int>>()

    // 暴力
    fun book1(start: Int, end: Int): Boolean {
        if (exists.isNotEmpty()) {
            for (exist in exists) {
                if (start < exist.second && end > exist.first) {
                    return false
                }
            }
        }
        exists.add(start to end)
        return true
    }

    val map = TreeMap<Int, Int>()
    fun book(start: Int, end: Int): Boolean {
        val ceil = map.ceilingKey(start)
        val floor = map.floorKey(start)

        if (ceil != null && end > ceil) return false
        if (floor != null && start < map[floor]!!) return false

        map[start] = end
        return true
    }
}

fun main() {
    println(MyCalendar_729.book(10, 20))
    println(MyCalendar_729.book(15, 25))
    println(MyCalendar_729.book(20, 30))
}