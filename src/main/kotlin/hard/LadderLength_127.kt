package hard

import common.printSelf

object LadderLength_127 {
    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        if (!wordList.toSet().contains(endWord)) {
            return 0
        }
        if (isAdj(beginWord, endWord)) {
            return 2
        }
        val len = beginWord.length
        val wl = wordList.filter { it.length == len }
        val wll = wl.size
        // begin直接相邻的
        val wla = wl.withIndex().filter { (i, v) -> isAdj(v, beginWord) }.map { (i, v) -> i }
        val wsa = Array(wll) { mutableListOf<Int>() }
        for (i in 0 until wll) {
            for (j in i + 1 until wll) {
                if (isAdj(wl[i], wl[j])) {
                    wsa[i].add(j)
                    wsa[j].add(i)
                }
            }
        }
        val visited = hashSetOf<Int>()
        var last: Set<Int> = wla.toHashSet()
        val tgt = wl.indexOf(endWord)
        if (last.isEmpty()) return 0
        if (last.contains(tgt)) return 2
        var step = 2
        while (visited.size < wll) {
//            last.printSelf()
//            println(step)
            visited.addAll(last)
            last = last.map { wsa[it] }.flatten().toSet()
            last = last - visited
            step++
            if (last.contains(tgt)) return step
            if (last.isEmpty())return 0
        }
        return 0
    }

    fun isAdj(s1: String, s2: String): Boolean {
        var diffCount = 0
        for (i in 0 until s1.length) {
            if (s1[i] != s2[i]) {
                diffCount++
            }
            if (diffCount > 1) {
                return false
            }
        }
        return diffCount == 1
    }
}

fun main() {
    val r = LadderLength_127.ladderLength(
        "hit",
        "cog",
        listOf(
            "hot", "dot", "tog",  "cog"
        )
    )
    println(r)
}