package jzof

import kotlin.math.max
import kotlin.math.min


object JZ61 {
    fun IsContinuous(numbers: IntArray): Boolean {
        // write code here
        var maxV = 0
        var minV = 14
        var flag = 0
        for (number in numbers) {
            if (number == 0) {
                continue
            }
            if ((flag shr number) and 1 > 0) {
                return false
            }
            minV = min(minV, number)
            maxV = max(maxV, number)
            flag = flag or (1 shl number)

        }
        return maxV - minV < 5
    }
}