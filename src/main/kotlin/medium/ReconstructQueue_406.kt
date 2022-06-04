package medium

import java.util.*

object ReconstructQueue_406 {
    fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
        if (people.size <= 1) return people
        val heap = PriorityQueue<IntArray> { i, j -> if (j[0] - i[0] != 0) j[0] - i[0] else i[1] - j[1] }
        people.forEach { heap.add(it) }
        val result = mutableListOf<IntArray>()
        while (heap.isNotEmpty()) {
            val tmp = heap.poll()
            if (result.isEmpty()) {
                result.add(tmp)

            } else {
                val value = tmp[0]
                val grade = tmp[1]
                if (grade == 0) {
                    result.add(0, tmp)
                    continue
                }

                var count = 0
                for (i in result.indices) {
                    if (result[i][0] >= value) {
                        count++
                    }
                    if (grade == count) {
                        result.add(i+1,tmp)
                        break
                    }
                }
            }
        }
        return result.toTypedArray()
    }
}