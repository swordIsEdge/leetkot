package jzof

object JZ45 {
    fun PrintMinNumber(numbers: IntArray): String {
        // write code here
        val sl = numbers.map(Int::toString).toList()
        val s2 = sl.sortedWith{s1,s2->(s1+s2).compareTo(s2+s1)}
        val result = s2.joinToString(separator = "")
        return result
    }
}

fun main() {
    val reuslt = JZ45.PrintMinNumber(intArrayOf(3,11))
    print(reuslt)
}