package easy

object MySqrt_69 {
    fun mySqrt(x: Int): Int {
        if (x <= 1) {
            return x
        }
        var left = 0
        var right = x
        while (left +1< right) {
            val mid = (left + right) shr 1
            if (x/mid>=mid) {
                left = mid
            } else {
                right = mid
            }
        }
        return left
    }
}

fun main() {
    val list = intArrayOf(2, 8, 9, 13, 16, 20)
    for (i in list) {
        val r = MySqrt_69.mySqrt(i)
        println(r)
    }

}