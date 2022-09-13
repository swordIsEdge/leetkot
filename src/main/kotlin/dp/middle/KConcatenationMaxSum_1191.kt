package dp.middle

import common.printSelf

object KConcatenationMaxSum_1191 {
    fun kConcatenationMaxSum(arr: IntArray, k: Int): Int {
        val REM = 1000000007
        val len = arr.size
        var singleTmp = arr[0]
        var singleMax = 0
        for (i in 1 until len) {
            if (singleTmp < 0) {
                singleTmp = 0
            }
            singleTmp += arr[i]
            singleMax = maxOf(singleMax, singleTmp)
        }

        if (k == 1) {
            return singleMax
        } else {
            var leftMax = 0
            var leftTmp = 0
            for (num in arr) {
                leftTmp += num
                leftMax = maxOf(leftMax, leftTmp)
            }
            var rightMax = 0
            var rightTmp = 0
            for (j in len - 1 downTo 0) {
                rightTmp += arr[j]
                rightMax = maxOf(rightMax, rightTmp)
            }

            var sum = 0
            arr.forEach { sum += it }
            if (sum > 0) {
                var res = ((sum.toLong() % REM) * (k - 2) % REM + (leftMax.toLong() + rightMax.toLong())) % REM
                res = res % REM
                return res.toInt()
            } else {
                return maxOf(singleMax, leftMax + rightMax)
            }
        }
    }
}

fun main() {
    val arr = intArrayOf(-1, -2)
    val k = 7
    val res = KConcatenationMaxSum_1191.kConcatenationMaxSum(arr, k)
    res.printSelf()
}