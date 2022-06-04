package medium

object CanFinish_207 {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val cache = BooleanArray(numCourses) { false }
        val visited = BooleanArray(numCourses) { false }
        val table = Array(numCourses) { mutableListOf<Int>() }
        for (prerequisite in prerequisites) {
            val tmp = prerequisite[0]
            val pre = prerequisite[1]
            table[tmp].add(pre)
        }
        for (index in 0 until numCourses) {
            if (!dfs(visited, cache, table, index)) {
                return false
            }
        }
        return true
    }

    fun dfs(visited: BooleanArray, cache: BooleanArray, table: Array<MutableList<Int>>, index: Int): Boolean {
        if (visited[index]) return false
        if (cache[index]) return true
        val nexts = table[index]
        if (nexts.isEmpty()) {
            cache[index] = true
            return true
        } else {
            visited[index] = true

            for (nextItem in nexts) {
                val result = dfs(visited, cache, table, nextItem)
                if (!result) return false
            }
            visited[index] = false
            cache[index] = true
            return true
        }
    }
}