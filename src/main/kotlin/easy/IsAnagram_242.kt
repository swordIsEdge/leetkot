package easy

object IsAnagram_242 {
    fun isAnagram(s: String, t: String): Boolean {
        val a = String(s.toCharArray().sortedArray())
        val b = String(t.toCharArray().sortedArray())
        println(a)
        println(b)
        return a == b
    }
}

fun main() {
    IsAnagram_242.isAnagram(
        "anagram",
        "nagaram"
    )
}