package dp.middle

object Respace_M_17_13 {
    fun respace(dictionary: Array<String>, sentence: String): Int {
        if (sentence.isEmpty() || dictionary.contains(sentence)) return 0

        val tailDict = Array<MutableList<String>>(26) { mutableListOf() }
        dictionary.forEach { tailDict[it[it.length - 1] - 'a'].add(it) }
        val len = sentence.length
        val dp = IntArray(len)
        // 0最后一个未匹配
        // 1 最后一个匹配
        if (tailDict[sentence[0] - 'a'].contains(sentence.substring(0, 1))) {
            dp[0] = 0
        } else {
            dp[0] = 1
        }
        for (i in 1 until len) {
            val options = tailDict[sentence[i] - 'a']
            dp[i] = dp[i - 1] + 1
            for (option in options) {
                val l = option.length
                if (l > i + 1) {
                    continue
                } else if (l == i + 1) {
                    if (sentence.substring(0, i + 1) == option) {
                        dp[i] = 0
                        break
                    }

                } else {
                    if (sentence.substring(i + 1 - l, i + 1) == option) {
                        dp[i] = minOf(dp[i], dp[i - l])
                    }
                }
            }
        }
        return dp[len-1]
    }
}