package dp.middle

object CountTexts_2266 {
    val countMap = intArrayOf(0, 0, 3, 3, 3, 3, 3, 4, 3, 4)
    val threeMap = hashMapOf<Int, Int>()
    val fourMap = hashMapOf<Int, Int>()
    val yu = 1000000007
    fun countTexts(pressedKeys: String): Int {
        var result = 1L
        var start = 0
        var last = pressedKeys[0]
        for (i in pressedKeys.indices) {
            val c = pressedKeys[i]
            if (c != last) {
                val cCount = countMap[last - '0']
                result = result * getCounts(cCount, i - start) % yu

                last = c
                start = i
            }
        }
        result = result * getCounts(countMap[last - '0'], pressedKeys.length - start) % yu
        return result.toInt()
    }

    fun getCounts(cCount: Int, len: Int): Int {
        if (cCount == 3 && threeMap.containsKey(len)) {
            return threeMap[len]!!
        }
        if (cCount == 4 && fourMap.containsKey(len)) {
            return fourMap[len]!!
        }
        val result = if (len < 0) {
            0
        } else if (len <= 1) {
            1
        } else {
           (1..cCount).map { getCounts(cCount, len - it)% yu }.reduce{r,it->(r+it)%yu}%yu

        }
        if (cCount == 3) {
            threeMap[len] = result
        }
        if (cCount == 4) {
            fourMap[len] = result
        }
        return result
    }
}

fun main() {
    val result = CountTexts_2266.countTexts("88888888888888888888888888888999999999999999999999999999994444444444444444444444444444488888888888888888888888888888555555555555555555555555555556666666666666666666666666666666666666666666666666666666666222222222222222222222222222226666666666666666666666666666699999999999999999999999999999888888888888888888888888888885555555555555555555555555555577777777777777777777777777777444444444444444444444444444444444444444444444444444444444433333333333333333333333333333555555555555555555555555555556666666666666666666666666666644444444444444444444444444444999999999999999999999999999996666666666666666666666666666655555555555555555555555555555444444444444444444444444444448888888888888888888888888888855555555555555555555555555555555555555555555555555555555555555555555555555555555555999999999999999555555555555555555555555555554444444444444444444444444444444555")
    print(result)
}