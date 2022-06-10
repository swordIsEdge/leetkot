package dp.middle

object GenerateParenthesis_M_08_09 {
    fun generateParenthesis(n: Int): List<String> {
        if (n == 0) return listOf("")
        if (n == 1) return listOf("()")
        val result = mutableListOf<String>()
        for (i in 0 until n) {
            val left = generateParenthesis(i)
            val right = generateParenthesis(n - 1 - i)

            for (l in left) {
                for (r in right) {
                    result.add("($l)$r")
                }
            }
        }
        return result
    }
}

fun main() {
    val r = GenerateParenthesis_M_08_09.generateParenthesis(3)
    for (s in r) {
        println(s)
    }


}