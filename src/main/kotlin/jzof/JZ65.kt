package jzof

object JZ65 {
    fun Add(num1: Int, num2: Int): Int {
        // write code here
        val base: Int = 0x00000001
        var a = false
        var result = 0
        for (i in 0..31) {
            val f = (base shl i) and num1 != 0
            val s = (base shl i) and num2 != 0
            result = result or ((if ( f xor s xor a) base else 0) shl i)
            a = (f and s) or (f and a) or (s and a)
        }
        return result
    }



}

fun main() {
    val r = JZ65.Add(12, 21)
    println(r)
    val res = Integer.toBinaryString(r)
    println(res)
}