package dataStructure

object FastMul {
    fun fastMul(x: Int, y: Int): Int {
        var result = 0
        var add = x
        var y = y
        while (y > 0) {
            if (y and 1 != 0) {
                result += add
            }
            add += add
            y = y shr 1
        }
        return result
    }
}

fun main() {
    val x = 123
    val y = 456
    println(x * y == FastMul.fastMul(x, y))
}