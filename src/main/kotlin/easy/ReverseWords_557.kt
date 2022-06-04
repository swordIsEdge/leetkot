package easy

object ReverseWords_557 {
    fun reverseWords(s: String): String {
        val result = StringBuilder()
        var i = 0
        var j = 0
        while (j < s.length) {
            if (s[j] == ' ') {
                result.append(reverseString(s.substring(i, j)))
                result.append(' ')
                i = j+1
            }
            j++
        }
        result.append(reverseString(s.substring(i, j)))
        return result.toString()
    }

    fun reverseString(s: String): String {
        val len = s.length
        if (len <= 1) return s
        val result = CharArray(len) { ' ' }
        for (i in 0..(len / 2)) {
            val nextIndex = len - 1 - i
            result[i] = s[nextIndex]
            result[nextIndex] = s[i]
        }
        return String(result)
    }

}