package jzof

object JZ56 {
    fun FindNumsAppearOnce(array: IntArray): IntArray  {
        // write code here
        var tmp = 0
        for (i in array) {
            tmp = tmp xor i
        }
        var k = 1
        while (k and tmp == 0) {
            k = k shl 1
        }

        var res1 = 0
        var res2 = 0
        for (i in array) {
            if (i and k != 0) {
                res1 = res1 xor i
            } else {
                res2 = res2 xor i
            }
        }
        return intArrayOf(minOf(res1,res2), maxOf(res1,res2))
    }
}