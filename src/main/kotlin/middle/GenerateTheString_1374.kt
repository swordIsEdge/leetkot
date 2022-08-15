package middle

object GenerateTheString_1374 {
    fun generateTheString(n: Int): String {
        if (n % 2 == 0) {
            return generateTheString(n - 1) + "b"
        } else {
            val sb = StringBuilder()
            for (i in 0 until n) {
                sb.append('a')
            }
            return sb.toString()
        }
    }
}