package jzof

object JZ53 {
    fun GetNumberOfK(data: IntArray, k: Int): Int {
        // write code here
        val index = binarySearch(data, k)
        return if (index < 0) {
            0
        } else count(data, k, index)
    }

    fun binarySearch(data: IntArray, k: Int): Int {
        var i = 0
        var j = data.size - 1
        while (i <= j) {
            val ind = (i + j) / 2
            val value = data[ind]
            if (k == value) {
                return ind
            } else if (value < k) {
                i = ind + 1
            } else {
                j = ind - 1
            }
        }
        return -1
    }

    fun count(data: IntArray, v: Int, index: Int): Int {
        var count = 1
        for (i in index-1 downTo 0) {
            if (data[i] == v) {
                count++
            } else
                break
        }

        for (i in index+1 until data.size) {
            if (data[i] == v) {
                count++
            } else
                break
        }
        return count
    }

}