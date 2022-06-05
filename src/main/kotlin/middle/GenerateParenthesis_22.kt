package middle

object GenerateParenthesis_22 {
    fun generateParenthesis(n: Int): List<String> {
        val all = Array<List<String>>(n + 1) { listOf() }
        all[0] = listOf("")
        for (i in 1..n) {
            val tmp = mutableListOf<String>()
            for (m in 0 until i) {
                val line0 = all[m]
                val line1 = all[i - 1 - m]
                for (s in line0) {
                    for (s2 in line1) {
                        tmp.add("($s)$s2")
                    }
                }
            }
            all[i] = tmp
        }
        return all[n]

    }
}


