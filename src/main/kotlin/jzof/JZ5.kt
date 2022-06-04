package jzof

object JZ5 {
    fun replaceSpace(s: String): String {
        // write code here
        val chars = mutableListOf<Char>()
        s.toCharArray().forEach {
            if (it == ' ') {
                chars.add('%')
                chars.add('2')
                chars.add('0')
            } else {
                chars.add(it)
            }
        }
        return String(chars.toCharArray())
    }
}