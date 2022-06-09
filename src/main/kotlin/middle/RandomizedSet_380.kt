package middle

import java.util.TreeSet

class RandomizedSet_380 {
    val treeSet = TreeSet<Int>()

    fun insert(`val`: Int): Boolean {
        if (!treeSet.contains(`val`)) {
            treeSet.add(`val`)
            return true
        }
        return false
    }

    fun remove(`val`: Int): Boolean {
        if (!treeSet.contains(`val`)) {
            treeSet.remove(`val`)
            return true
        }
        return false
    }

    fun getRandom(): Int {
        return treeSet.random()
    }
}

fun main() {
    val r = RandomizedSet_380()
    r.insert(1)
    r.remove(2)
    r.insert(2)
    r.getRandom()
    r.remove(1)
    r.insert(2)
    r.getRandom()
}