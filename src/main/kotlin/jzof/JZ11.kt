package jzof

object JZ11 {
    fun minNumberInRotateArray(rotateArray: IntArray): Int {
        // write code here


        var i = 0
        var j = rotateArray.size - 1
        while (i < j) {
            val ind = (i + j) / 2
            val value = rotateArray[ind]
            val flag = rotateArray[j]
            if (value > flag) {
                i = ind + 1
            } else if (value < flag) {
                j = ind
            } else {
                j--
            }
        }
        return rotateArray[j]
    }
}

fun main() {
    val ia = intArrayOf(3, 4, 5, 1, 2)
    val res = JZ11.minNumberInRotateArray(ia)
    println(res)
}