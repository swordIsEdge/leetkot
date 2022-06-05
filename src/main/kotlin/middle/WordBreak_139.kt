package middle

object WordBreak_139 {
    var cache = hashMapOf<Int,Boolean>()
    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        return dfs(s, 0, wordDict)
    }

    fun dfs(s: String, index: Int, wordDict: List<String>): Boolean {
        if (index >= s.length) {
            return true
        }
        if (cache.containsKey(index)) {
            return cache[index]!!
        }
        for (word in wordDict) {
            if (stringStart(s, index, word)) {
                val next = dfs(s, index + word.length, wordDict)
                cache[index+word.length] = next
                if (next) return true
            }
        }
        return false

    }

    private fun stringStart(s: String, index: Int, word: String): Boolean {
        for (i in word.indices) {
            if (index + i >= s.length) {
                return false
            }
            if (s[i + index] != word[i]) return false
        }
        return true
    }
}