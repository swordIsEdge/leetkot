package easy

object LongestCommonPrefix_14 {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""
        if (strs.size == 1) return strs[0]
        var longestCommon = strs[0]
        for (i in 1 until strs.size) {
            val minLen = minOf(longestCommon.length, strs[i].length)
            if (minLen == 0) return ""
            var resultMin = minLen
            for (j in minLen - 1 downTo 0) {
                if (longestCommon[j] != strs[i][j]) {
                    resultMin = j
                }
            }
            if (resultMin == 0) return ""
            longestCommon = longestCommon.substring(0, resultMin)
        }
        return longestCommon
    }
}

fun main() {
    val r = LongestCommonPrefix_14.longestCommonPrefix(arrayOf(
        "flower","flow","flight"
    ))
    println(r)
}