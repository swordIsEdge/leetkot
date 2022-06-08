package middle

object CountAndSay_38 {
    fun countAndSay(n: Int): String {
        if (n == 1) return "1"
        else {
            val s = countAndSay(n - 1)

            var count = 1
            var c = s[0]
            val result = StringBuilder()
            for (i in 1 until s.length) {
                val cur = s[i]
                if (cur != c) {
                    result.append(count)
                    result.append(c)
                    c = cur
                    count = 1
                } else {
                    count++
                }
            }
            result.append(count)
            result.append(c)
            return result.toString()
        }

    }
}

fun main() {
    println(CountAndSay_38.countAndSay(6))
}