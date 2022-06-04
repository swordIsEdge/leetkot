package easy

object AddBinary_67 {
    fun addBinary(a: String, b: String): String {
        if (a.isEmpty()) return b
        if (b.isEmpty()) return a
        val result = mutableListOf<Char>()

        var remain = 0
        val len = maxOf(a.length, b.length)
        for (i in 0 until len) {
            val ac = if (i >= a.length) 0 else a[a.length - 1 - i] - '0'
            val bc = if (i >= b.length) 0 else b[b.length - 1 - i] - '0'
            result.add('0' + (remain + ac + bc) % 2)
            remain = (remain + ac + bc) / 2
        }
        if (remain != 0) {
            result.add('0'+remain)
        }

        result.reverse()
        return String(result.toCharArray())
    }
}