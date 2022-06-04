package hard

object ConsecutiveNumbersSum_829 {
    fun consecutiveNumbersSum(n: Int): Int {
        var count = 0
        var numCount = 2
        while (numCount * (numCount) <= n * 2) {
            if (numCount % 2 == 1) {
                if (n % numCount == 0) {
                    count += 1
                }
            } else { //共有numCount/2对数
                val numPair = numCount shr 1
                if (n % numPair == 0) {
                    count += handleEven(numPair, n)
                }

            }
            numCount++
        }
        return count + 1

    }


    fun handleEven(pair: Int, n: Int): Int {
        val pairSum = n / pair //每对的两数和
        if (pairSum % 2 == 0) return 0
        val low = pairSum shr 1
        val down = low - pair + 1
        return if (down > 0) 1 else 0
    }
}

fun main() {
    val r = ConsecutiveNumbersSum_829.consecutiveNumbersSum(15)
    println(r)
}