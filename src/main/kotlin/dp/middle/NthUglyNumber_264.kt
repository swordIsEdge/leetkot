package dp.middle

object NthUglyNumber_264 {
    fun nthUglyNumber(n: Int): Int {
        val result = IntArray(n) { 1 }
        val dpIndex = IntArray(3){0} // 分别指向2,3,5
        val dpFactor = intArrayOf(2, 3, 5)
        for (i in 1 until n) {
            val last = result[i - 1]
            var min = dpIndex[0] shl 1
            do {
                var minIndex = 0
                min = Int.MAX_VALUE
                for (j in 0 until dpIndex.size) {
                    if (min > result[dpIndex[j]] * dpFactor[j]) {
                        min = result[dpIndex[j]] * dpFactor[j]
                        minIndex = j
                    }
                }
                dpIndex[minIndex]++
//                println("$min  $last")
            } while (min == last)
//            dpIndex.printSelf()

            result[i] = min
        }
        return result[n - 1]
    }
}

fun main() {
    println(NthUglyNumber_264.nthUglyNumber(11))
}