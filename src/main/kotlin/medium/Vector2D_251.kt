package medium

class Vector2D_251(vec: Array<IntArray>) {

    var vec: Array<IntArray> = arrayOf()

    init {
        this.vec = vec.filter { it.isNotEmpty() }.toTypedArray()
    }

    var i = 0
    var j = 0
    fun next(): Int {
        while (j >= vec[i].size) {
            j = 0
            i++
        }
        return vec[i][j++]
    }

    fun hasNext(): Boolean {
        return i < vec.size-1 || (i==vec.size-1 && j < vec[i].size)
    }
}

fun main() {
    val c = Vector2D_251(
        arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3),
            intArrayOf(4)

        )
    )
    for (i in 1..4) {
        println(c.next())
    }
}