package medium

object CalcEquation_399 {
    fun calcEquation(equations: List<List<String>>, values: DoubleArray, queries: List<List<String>>): DoubleArray {
        val indexMap = hashMapOf<String, Int>()
        var count = 0
        for (equation in equations) {
            if (!indexMap.containsKey(equation[0])) {
                indexMap[equation[0]] = count++
            }
            if (!indexMap.containsKey(equation[1])) {
                indexMap[equation[1]] = count++
            }
        }
        val grid = Array(count) { DoubleArray(count) { Double.MAX_VALUE } }
        for ((i, equation) in equations.withIndex()) {
            grid[indexMap[equation[0]]!!][indexMap[equation[1]]!!] = values[i]
            grid[indexMap[equation[1]]!!][indexMap[equation[0]]!!] = 1.0 / values[i]
        }
        for (i in 0 until count) {
            for (j in 0 until count) {
                for (k in 0 until count) {
                    if (grid[j][k] != Double.MAX_VALUE) {
                        continue  //jk之间的值已经计算过了
                    }
                    if (grid[i][k] == Double.MAX_VALUE || grid[j][i] == Double.MAX_VALUE) {
                        continue // jk 之间无法计算
                    }
                    grid[j][k] = grid[j][i] * grid[i][k]
                }
            }
        }
        val res = DoubleArray(queries.size)
        for ((i, query) in queries.withIndex()) {
            res[i] = if (!indexMap.containsKey(query[0]) || !indexMap.containsKey(query[1])) {
                -1.0
            } else {
                val value = grid[indexMap[query[0]]!!][indexMap[query[1]]!!]
                if (value == Double.MAX_VALUE)
                    -1.0
                else
                    value
            }
        }
        return res
    }
}