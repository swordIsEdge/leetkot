package dp.middle

import common.printSelf

object CountVowels_2063 {
    fun countVowels(word: String): Long {
        var result = 0L
        val len = word.length
        val y = setOf('a','e','i','o','u')
        for ((index, char) in word.withIndex()) {
            if (char in y) {
                val left = index+1
                val right= len-index
                result+= left.toLong()*right.toLong()
            }
        }
        return result
    }
}

fun main() {
    val ss = listOf("aba","abc","ltcd","noosabasboosa")
    for (s in ss) {
        val res = CountVowels_2063.countVowels(s)
        res.printSelf()
        println()
    }
}