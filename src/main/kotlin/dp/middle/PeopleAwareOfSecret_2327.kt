package dp.middle

import common.printSelf
import java.util.LinkedList

object PeopleAwareOfSecret_2327 {
    fun peopleAwareOfSecret(n: Int, delay: Int, forget: Int): Int {
        val rem = 1000000007
        val queue = LinkedList<Long>()
        for (i in 0 until forget) {
            queue.push(0)
        }
        for (i in 0 until n) {
//            println("at day $i")
            if (i == 0) {
                queue.push(1)

            } else {
                queue.push(0)
                var tmp = 0L
                for (j in delay until forget) {
//                    println("queue$j = ${queue[j]}")
                    tmp += (queue[j] % rem)
                }
//                println("day $i, newAdd $tmp")
                queue[0] = tmp
                queue.removeLast()
            }
        }
        var result = 0L
        for (j in 0 until forget) {
            result += (queue[j] % rem)
            result = result%rem
        }
        return result.toInt()

    }
}

fun main() {
    val res = PeopleAwareOfSecret_2327.peopleAwareOfSecret(684, 18, 496)
    res.printSelf()
}