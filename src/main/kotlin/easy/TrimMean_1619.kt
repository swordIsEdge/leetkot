package easy

import common.parserIntArray
import common.printSelf

object TrimMean_1619 {
    fun trimMean(arr: IntArray): Double {
        val n = arr.size
        var count = 0
        var sum = 0.0
        arr.sort()
        for (i in (n / 20)until (n * 19 / 20)) {
            count++
            sum += arr[i]
        }
        return sum/count
    }
}

fun main() {
    val s = "[6,0,7,0,7,5,7,8,3,4,0,7,8,1,6,8,1,1,2,4,8,1,9,5,4,3,8,5,10,8,6,6,1,0,6,10,8,2,3,4]"
    val arr = parserIntArray(s)
    val res = TrimMean_1619.trimMean(arr)
    res.printSelf()
}