package middle

import kotlin.random.Random

class Pick_497(rects: Array<IntArray>) {
    val rect = rects
    val count = IntArray(rects.size) { 0 }
    var max = 0

    init {
        for ((i, rect) in rects.withIndex()) {
            val a = rect[0]
            val b = rect[1]
            val x = rect[2]
            val y = rect[3]
            val c = (x - a + 1) * (y - b + 1)
            if (i == 0) {
                count[0] = c
            } else {
                count[i] = count[i - 1] + c
            }
        }
        max = count[count.size - 1]

    }

    fun pick(): IntArray {
        val ind = Random.nextInt(max) + 1
        var left = 0
        var right = count.size - 1
        while (left < right) {
            val mid = (left + right) shr 1
            val v = count[mid]
            if (v >= ind) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        // 命中right个正方形
        val r = rect[right]
        val a = r[0]
        val b = r[1]
        val x = r[2]
        val y = r[3]
        val h = x - a
        val w = y - b
        val rx = Random.nextInt(h+1)
        val ry = Random.nextInt(w+1)
        return intArrayOf(a+rx,b+ry)
    }

}