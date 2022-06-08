package hard

import java.util.*

object MedianFinder_395 {

    val low = PriorityQueue<Int> { i, j -> j.compareTo(i) }
    val high = PriorityQueue<Int>()
    var count = 0

    fun addNum(num: Int) {
        count++
        low.add(num)
        high.add(low.poll())
        if (count % 2 == 0) {
            low.add(high.poll())
        }

    }

    fun findMedian(): Double {
        if (count % 2 == 0) {
            return (low.peek()+ high.peek())/2.0
        } else {
            return high.peek()*1.0
        }
    }
}