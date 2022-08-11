package easy

import common.printSelf
import kotlin.math.abs


object Reformat_1417 {
    fun reformat(s: String): String {
        val nums = mutableListOf<Char>()
        val chars = mutableListOf<Char>()
        for (c in s) {
            if (c.isDigit()) {
                nums.add(c)
            } else {
                chars.add(c)
            }
        }
        if (abs(nums.size-chars.size)>1) return ""
        var i = 0
        var j = 0
        val result = StringBuilder()
        if (nums.size >= chars.size) {
            result.append(nums[i++])
        }
        while (j < chars.size) {
            result.append(chars[j++])
            if (i < nums.size) {
                result.append(nums[i++])
            }
        }
        return result.toString()
    }
}

fun main() {
    val s = "covid2019"
    val res = Reformat_1417.reformat(s)
    res.printSelf()
}