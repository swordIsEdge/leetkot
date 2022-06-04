package medium


object GrayCode {
    fun grayCode(n: Int): List<Int> {
        val len = 1 shl n
        val result = IntArray(len) { 0 }
        for (i in 0 until n) {
            val curBitOne = 1 shl i
            val circleLen = 1 shl (i + 2)
            val start = 1 shl i
            val end = circleLen - start - 1
            for (j in result.indices) {
                val num = j % circleLen
                val isOne = num >= start && num <= end
                if (isOne) result[j] = result[j] or curBitOne
            }
        }
        return result.asList()
    }
    fun grayCode2(n: Int): List<Int> {
        val ret: MutableList<Int> = ArrayList()
        for (i in 0 until (1 shl n)) {
            ret.add(i shr 1 xor i)
        }
        return ret
    }
}

fun main() {
    val r = GrayCode.grayCode(2)
    for (i in r) {
        print("$i->")
    }
}
