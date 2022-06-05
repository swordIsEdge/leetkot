package middle

object LetterCombinations_17 {
    val map = mapOf(
        '2' to charArrayOf('a', 'b', 'c'),
        '3' to charArrayOf('d', 'e', 'f'),
        '4' to charArrayOf('g', 'h', 'i'),
        '5' to charArrayOf('j', 'k', 'l'),
        '6' to charArrayOf('m', 'n', 'o'),
        '7' to charArrayOf('p', 'q', 'r', 's'),
        '8' to charArrayOf('t', 'u', 'v'),
        '9' to charArrayOf('w', 'x', 'y', 'z')
    )

    fun letterCombinations(digits: String): List<String> {
        if (digits.isBlank()) return listOf()
        var last = mutableListOf<CharArray>()
        var next = mutableListOf<CharArray>()

        for (c in map[digits[0]]!!) {
            last.add(charArrayOf(c))
        }
        for (i in 1 until digits.length) {
            val local  = digits[i]
            for (c in map[local]!!) {
                for (ca in last) {
                    next.add(ca.plus(c))
                }
            }
            last = next
            next = mutableListOf()
        }
        val result = last.map { ca->String(ca) }
        return  result
    }
}