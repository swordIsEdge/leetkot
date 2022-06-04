package jzof

object JZ51 {
    var count = 0
    fun InversePairs(data: IntArray): Int {
        // write code here
        splitAndMerge(data, 0, data.size - 1)
        return count
    }

    fun splitAndMerge(data: IntArray, start: Int, end: Int) {
        if (start >= end) {
            return
        }
        val medium = (start + end) / 2
        splitAndMerge(data, start, medium)
        splitAndMerge(data, medium + 1, end)
        merge(data, start, end, medium)
    }

    fun merge(data: IntArray, start: Int, end: Int, medium: Int) {
        val tmp = IntArray(end - start + 1)
        var i = start
        var j = medium + 1
        var ind = 0
        while (i <= medium || j <= end) {
            if (i > medium) {
                for (index in j..end) {
                    tmp[ind++] = data[index]
                }
                break
            } else if (j > end) {
                for (index in i..medium) {
                    tmp[ind++] = data[index]
                }
                break
            } else {
                val left = data[i]
                val right = data[j]
                if (left <= right) {
                    i++
                    tmp[ind++] = left
                } else {
                    tmp[ind++] = right
                    count = count + medium - i + 1
                    count %= 1000000007
                    j++
                }
            }
        }
        for (index in 0 until (end - start + 1)) {
            data[start + index] = tmp[index]
        }
    }
}

fun main() {
    val res = JZ51.InversePairs(intArrayOf(1, 2, 3, 4, 5, 6, 7, 0))
    println(res)
}