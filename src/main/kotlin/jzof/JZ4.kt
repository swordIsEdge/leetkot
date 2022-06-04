package jzof

object JZ4 {
    fun Find(target: Int, array: Array<IntArray>): Boolean {
        // write code here
        val h = array.size
        val w = array[0].size
        var i = 0
        var j = w - 1
        while (i < h && j >= 0) {
            val value = array[i][j]
            if (value == target) {
                return true
            } else if (value > target) {
                j--
            } else {
                i++
            }
        }
        return false

    }
}