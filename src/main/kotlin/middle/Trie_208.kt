package middle

class Trie_208 {
    private val nodeRoot = Node()
    fun insert(word: String) {
        var tmp = nodeRoot
        for (c in word) {
            if (tmp.nexts[c - 'a'] == null) {
                tmp.nexts[c - 'a'] = Node()
            }
            tmp = tmp.nexts[c - 'a']!!
        }
        tmp.hasWord = true
    }

    fun search(word: String): Boolean {
        var tmp = nodeRoot
        for (c in word) {
            if (tmp.nexts[c - 'a'] == null) {
                return false
            }
            tmp = tmp.nexts[c - 'a']!!
        }
        return tmp.hasWord
    }

    fun startsWith(prefix: String): Boolean {
        var tmp = nodeRoot
        for (c in prefix) {
            if (tmp.nexts[c - 'a'] == null) {
                return false
            }
            tmp = tmp.nexts[c - 'a']!!
        }
        return true
    }

    private class Node {
        var hasWord = false
        var nexts = Array<Node?>(26) { null }
    }
}