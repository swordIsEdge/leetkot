package middle

object GroupAnagrams_49 {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = hashMapOf<String, MutableList<String>>()
        for (str in strs) {
            val orderedStr = str.toCharArray()
            orderedStr.sort()
            val s = String(orderedStr)
            if (map.containsKey(s)) {
                map[s]!!.add(str)
            } else {
                map[s] = mutableListOf(str)
            }
        }
        return map.values.toList()
    }
}