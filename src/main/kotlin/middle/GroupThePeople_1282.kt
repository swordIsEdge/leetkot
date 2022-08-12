package middle

import common.printSelf

object GroupThePeople_1282 {
    fun groupThePeople(groupSizes: IntArray): List<List<Int>> {
        val map = hashMapOf<Int,MutableList<Int>>()
        val result = mutableListOf<List<Int>>()
        for ((index,gs) in groupSizes.withIndex()) {
            val tmpList = map.getOrPut(gs){ mutableListOf() }
            tmpList.add(index)
            if (tmpList.size == gs) {
                result.add(tmpList)
                map[gs] = mutableListOf()
            }
        }
        return result
    }
}

fun main() {
    val ar = intArrayOf(2,1,3,3,3,2)
    val res = GroupThePeople_1282.groupThePeople(ar)
    for (re in res) {
        re.printSelf()
    }
}