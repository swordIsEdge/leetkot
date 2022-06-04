package easy

object FirstUniqChar_387 {
    fun firstUniqChar(s: String): Int {
        val cm = IntArray(26){ 0}
        s.forEach { cm[it-'a']++ }
        for (index in s.indices) {
            if (cm[s[index] - 'a'] == 1) {
                return index
            }
        }
        return -1
    }
}