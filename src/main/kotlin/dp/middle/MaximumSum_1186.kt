package dp.middle

import common.parserIntArray
import common.printSelf


object MaximumSum_1186 {
    fun maximumSum(arr: IntArray): Int {
        val len = arr.size
        if (len == 1) return arr[0]


        val dpLeft = IntArray(len)
        val dpRight = IntArray(len)

        var nextNode = 0
        for (i in 0 until len) {
            if (i == nextNode) {
                var max = arr[i]
                var sum = arr[i]
                nextNode = i + 1
                for (j in i + 1 until len) {
                    sum += arr[j]
                    if (sum >= max) {
                        max = sum
                        nextNode = j + 1
                    }
                }
                dpLeft[i] = max
            } else {
                dpLeft[i] = dpLeft[i - 1] - arr[i - 1]
            }
        }
        nextNode = len - 1
        for (i in len - 1 downTo 0) {
            if (i == nextNode) {
                var max = arr[i]
                var sum = arr[i]
                nextNode = i - 1
                for (j in i - 1 downTo 0) {
                    sum += arr[j]
                    if (sum >= max) {
                        max = sum
                        nextNode = j - 1
                    }
                }
                dpRight[i] = max
            } else {
                dpRight[i] = dpRight[i + 1] - arr[i + 1]
            }
        }
        var res = arr[0]
        for (i in 0..len) {
            if (i == 0) {
                res = maxOf(res, dpLeft[0])
                res = maxOf(res, dpLeft[1])
            }
            if (i == len) {
                res = maxOf(res, dpRight[len - 1])
                res = maxOf(res, dpRight[len - 2])
            }
            if (i != 0 && i != len) {
                res = maxOf(res, dpRight[i - 1] + dpLeft[i])
                if (i != len - 1) res = maxOf(res, dpRight[i - 1] + dpLeft[i + 1])
            }
        }
        return res
    }
}

fun main() {
    val s = "[-1,-1,-1,-1]"
    val arr = parserIntArray(s)
    val res = MaximumSum_1186.maximumSum(arr)
    res.printSelf()
}