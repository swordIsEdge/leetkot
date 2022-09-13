package easy

import common.printSelf

object IsPrefixOfWord_1455 {
    fun isPrefixOfWord(sentence: String, searchWord: String): Int {
        var index = 0
        val len = sentence.length

        if (isPrefix(sentence, 0, searchWord)) return 1

        var wordIndex = 1
        while (index < len) {
            val c = sentence[index]
            if (c == ' ' && index != len - 1) {
                wordIndex += 1
                if (isPrefix(sentence, index + 1, searchWord)) {
                    return wordIndex
                }
            }
            index++
        }
        return -1
    }

    fun isPrefix(sentence: String, startIndex: Int, searchWord: String): Boolean {
        val len = sentence.length
        val lenWord = searchWord.length
        if (startIndex + lenWord - 1 >= len) {
            return false
        }
        for (i in startIndex until startIndex + lenWord) {
            val c1 = sentence[i]
            val c2 = searchWord[i - startIndex]
            if (c1 != c2)
                return false
        }
        return true
    }
}

fun main() {
    val s1 = "i am tired"
    val s2 = "you"
    val res = IsPrefixOfWord_1455.isPrefixOfWord(s1, s2)
    res.printSelf()
}