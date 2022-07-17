package jzof

class JZOD_II_041_MovingAverage(size: Int) {

    val size: Int
    val data: MutableList<Int>
    var sum = 0

    /** Initialize your data structure here. */
    init {
        this.size = size
        data = mutableListOf()
    }

    fun next(`val`: Int): Double {
        data.add(`val`)
        if (data.size > this.size) {
            val first = data.removeAt(0)
            sum -= first
        }
        sum += `val`
        return sum * 1.0 / data.size
    }
}