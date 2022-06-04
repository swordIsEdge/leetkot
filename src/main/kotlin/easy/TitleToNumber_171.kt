package easy

object TitleToNumber_171 {
    fun titleToNumber(columnTitle: String): Int {
        if (columnTitle.isEmpty()) return 0
        var sum = 0
        var base = 1
        for (i in columnTitle.length - 1 downTo 0) {
            val c = columnTitle[i]

            sum+=(c-'A'+1)*base

            base*=26
        }
        return sum
    }
}

fun main() {
    val a = TitleToNumber_171.titleToNumber("AB")
    println(a)
}