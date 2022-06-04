package easy

import common.printSelf

object Generate_118 {
    fun generate(numRows: Int): List<List<Int>> {
        if(numRows==0) return listOf()
        val result = MutableList(numRows){ listOf<Int>() }
        result[0] = listOf(1)
        for (i in 1 until numRows) {
            val last = result[i - 1]
            val thisList = mutableListOf<Int>()
            thisList.add(1)
            for (j in 1 until i ) {
                thisList.add(last[j]+last[j-1])
            }
            thisList.add(1)
            result[i] = thisList
        }
        return result
    }
}

fun main() {
    val r = Generate_118.generate(5)
    for (ints in r) {
        ints.printSelf()
    }
}