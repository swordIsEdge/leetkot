package dp.middle

object GenerateParenthesis_jzof_II_085 {
    val cache = hashMapOf<Int, List<String>>()

    fun generateParenthesis(n: Int): List<String> {
        if (cache.containsKey(n)) return cache[n]!!
        if (n == 0) return listOf("")
        val result = mutableListOf<String>()
        for (i in 0 until n) {
            val left = generateParenthesis(i)
            val right = generateParenthesis(n - 1 - i)
            result.addAll(left.flatMap { lItem -> right.map { "($lItem)$it" } })
        }
        cache[n] = result
        return result
    }
}