package hard

import common.printSelf

class WordFilter_745(words: Array<String>) {
    val preTrie = TrieNode()
    val sufTrie = TrieNode()

    init {
        for ((index, word) in words.withIndex()) {
            insertToTrie(preTrie, word, 0, index)
            insertToTrie(sufTrie, word.reversed(), 0, index)
        }
    }

    fun f(pref: String, suff: String): Int {
        val s1 = search(preTrie, pref, 0)
        val s2 = search(sufTrie, suff.reversed(), 0)
        return if (s1.isEmpty() || s2.isEmpty()) {
            -1
        } else {
            findFirstSame(s1, s2)
        }
    }

    private fun findFirstSame(l1: List<Int>, l2: List<Int>): Int {
        var i1 = l1.size - 1
        var i2 = l2.size - 1
        while (i1 >= 0 && i2 >= 0) {
            if (l1[i1] == l2[i2]) {
                return l1[i1]
            }else if (l1[i1] > l2[i2]) {
                i1--
            } else {
                i2--
            }
        }
        return -1
    }

    fun search(root: TrieNode, s: String, i: Int): List<Int> {
        if (i == s.length) {
            return root.indexs
        }
        val cIndex = s[i] - 'a'
        return if (root.childs[cIndex] == null) {
            listOf()
        } else {
            search(root.childs[cIndex]!!, s, i + 1)
        }
    }

    private fun insertToTrie(root: TrieNode, s: String, i: Int, value: Int) {
        root.indexs.add(value)

        if (i == s.length) {
            return
        }
        val cIndex = s[i] - 'a'
        if (root.childs[cIndex] == null) {
            root.childs[cIndex] = TrieNode()
        }
        insertToTrie(root.childs[cIndex]!!, s, i + 1, value)
    }
}

class TrieNode {
    val indexs = mutableListOf<Int>()
    val childs = Array<TrieNode?>(26) { null }
}

fun main() {
    val w = WordFilter_745(arrayOf("apple"))
    val i = w.f("a", "e")
    i.printSelf()
}