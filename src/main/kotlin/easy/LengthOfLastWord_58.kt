package easy

object LengthOfLastWord_58 {
    fun lengthOfLastWord(s: String): Int {
        var lb = s.length
        for (i in s.length - 1 downTo 0) {
            lb = i
            if (s[i] != ' ') {
                break
            }
        }
        val ns = s.substring(0, lb + 1)
        val lastIndex = ns.lastIndexOf(' ')
        return ns.length - lastIndex - 1
    }
}

fun main() {
    val l = LengthOfLastWord_58.lengthOfLastWord("   fly me   to   the moon  ")
    println(l)
}