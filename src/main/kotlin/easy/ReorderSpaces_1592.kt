package easy

import common.printSelf

object ReorderSpaces_1592 {
    fun reorderSpaces(text: String): String {
        val words = mutableListOf<String>()
        var spaceCount = 0
        var start = 0
        for ((index, char) in text.withIndex()) {
            if (char == ' ') {
                spaceCount++
                if (index != 0 && text[index - 1] != ' ') words.add(text.substring(start, index))
            } else {
                if (index == 0) start = 0
                else if (text[index - 1] == ' ') start = index

                if (index == text.length - 1) {
                    words.add(text.substring(start, index + 1))
                }
            }
        }

        val result = StringBuilder()

        if (spaceCount == 0) return text
        val wordCount = words.size
        if (wordCount == 1) {
            result.append(words[0])
            for (i in 0 until spaceCount) {
                result.append(' ')
            }
            return result.toString()
        }

        val average = spaceCount / (wordCount - 1)
        val remain = spaceCount % (wordCount - 1)


        for ((index, word) in words.withIndex()) {
            result.append(word)
            if (index != wordCount - 1) {
                for (i in 0 until average) {
                    result.append(' ')
                }
            }
        }
        for (i in 0 until remain) {
            result.append(' ')
        }
        return result.toString()
    }
}

fun main() {
    val s = "  hello"
    val result = ReorderSpaces_1592.reorderSpaces(s)
    result.printSelf()
}