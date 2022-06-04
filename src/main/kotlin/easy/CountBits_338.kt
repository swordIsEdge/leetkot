package easy

object CountBits_338 {
    fun countBits(n: Int): IntArray {
        if (n == 0) {
            return intArrayOf(0)
        }
        val result = IntArray(n + 1) { 0 }

        var index = 1
        var threshold = 1
        while (index <= n) {
            if (index == (threshold shl 1)) {
                threshold = threshold shl 1
            }
            result[index] = 1 + result[index - threshold]
            index++
        }
        return result
    }
}

fun main() {
    val res = CountBits_338.countBits(5)
    for (re in res) {
        println(re)
    }
}