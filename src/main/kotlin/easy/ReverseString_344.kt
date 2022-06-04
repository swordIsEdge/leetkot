package easy

object ReverseString_344 {
    fun reverseString(s: CharArray): Unit {
        val len = s.size
        if (len<=1) return
        for (i in 0..(len / 2 - 1)) {
            val nextIndex = len - 1 - i
            val tmp = s[i]
            s[i] = s[nextIndex]
            s[nextIndex] = tmp
        }
    }
}