package jzof

object JZ58 {
    fun LeftRotateString(str: String, n: Int): String {
        // write code here
        if (str.isBlank()) {
            return str
        }
        val len = str.length
        var newN = n % len
        if (newN == 0) {
            return str
        }
        return str.slice(newN until str.length) + str.slice(0 until newN)
    }


}