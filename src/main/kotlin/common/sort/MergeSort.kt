package common.sort

import common.printSelf

object MergeSort {
    fun top2Bot(data: IntArray) {
        top2Bot(data, 0, data.size - 1)
    }

    fun top2Bot(data: IntArray, start: Int, end: Int) {
        if (start >= end) return
        val mid = (end + start) shr 1
        top2Bot(data, start, mid)
        top2Bot(data, mid + 1, end)
        merge(data, start, mid, end)
    }

    private fun merge(data: IntArray, start: Int, mid: Int, end: Int) {
        println("merge $start -> $mid , ${mid + 1}-> $end")
        val tmp = IntArray(end - start + 1)
        var index = 0
        var i = start
        var j = mid + 1
        while (true) {
            if (i > mid) break
            if (j > end) break
            val min = if (data[i] < data[j]) {
                data[i++]
            } else {
                data[j++]
            }
            tmp[index++] = min
        }
        while (i <= mid) {
            tmp[index++] = data[i++]
        }
        while (j <= end) {
            tmp[index++] = data[j++]
        }
        for (k in start..end) {
            data[k] = tmp[k - start]
        }
    }


    fun bot2top(data: IntArray) {
        val len = data.size
        var step = 1
        while (step < len) {
            println("step = $step")
            val batch = step shl 1
            for (s in 0 until len step batch) {
                if (s + step - 1 < len - 1) {
                    merge(data, s, s + step - 1, minOf(s + batch - 1, len - 1))
                }
            }
            step = batch
        }


    }
}

fun main() {
    val ar = (0..19).toList().toIntArray()
    ar.shuffle()
    ar.printSelf()
    MergeSort.bot2top(ar)
    ar.printSelf()
}