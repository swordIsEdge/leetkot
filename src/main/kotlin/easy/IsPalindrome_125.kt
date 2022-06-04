package easy

object IsPalindrome_125 {
    fun isPalindrome(s: String): Boolean {
        val newS = s.filter { it.isLetter()||it.isDigit() }.toString()
        val len =newS.length
        if (len<=1) return true
        for (i in 0..(len / 2 - 1)) {
            val f = newS[i].toLowerCase()
            val s = newS[len-1-i].toLowerCase()
            if (s != f) {
                return false
            }
        }
        return true
    }
}