package easy

object StrStr {
    fun strStr(haystack: String, needle: String): Int {
        if (needle.isEmpty()) return 0
        if (needle.length> haystack.length) return -1
        if (needle.length == haystack.length) {
            return if (needle==haystack) 0 else -1
        }
        for (i in 0..(haystack.length - needle.length)) {
            for (j in needle.indices) {
                if (haystack[i + j] != needle[j]) {
                    break
                }
                if (j == needle.length - 1) {
                    return i
                }
            }
        }

        return -1
    }
}