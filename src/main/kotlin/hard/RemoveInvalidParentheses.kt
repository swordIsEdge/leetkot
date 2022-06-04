package hard

object RemoveInvalidParentheses {
    val result = hashSetOf<String>()
    var maxPair = 0
    var maxRmL = 0
    var maxRmR = 0

    fun removeInvalidParentheses(s: String): List<String> {
        var l = 0
        var r = 0
        for (c in s) {
            if (c == '(') l++
            else if (c == ')') {
                if (r < l) r++ //合法的右括号数量
                else maxRmR++
            }
        }
        maxPair = minOf(l, r)
        maxRmL = if (l > maxPair) l - maxPair else 0

        dfs(s, 0, 0, 0, 0, 0, StringBuilder())
        return result.toList()

    }

    fun dfs(s: String, index: Int, lCount: Int, rCount: Int, rmL: Int, rmR: Int, sb: StringBuilder) {
        if (rCount > lCount ||
            lCount > maxPair ||
            rCount > maxPair ||
            rmL > maxRmL ||
            rmR > maxRmR
        ) {
            return
        }
//        println("$sb $lCount $rCount")
        if (index == s.length) {
            result.add(sb.toString())
            return
        }
        val c = s[index]

        sb.append(c)
        when (c) {
            '(' -> {
                dfs(s, index + 1, lCount + 1, rCount, rmL, rmR, sb)
                sb.deleteCharAt(sb.length-1)
                dfs(s, index + 1, lCount, rCount, rmL + 1, rmR, sb)
            }
            ')' -> {
                dfs(s, index + 1, lCount, rCount + 1, rmL, rmR, sb)
                sb.deleteCharAt(sb.length-1)
                dfs(s, index + 1, lCount, rCount, rmL, rmR + 1, sb)
            }
            else -> {
                dfs(s, index + 1, lCount, rCount, rmL, rmR, sb)
                sb.deleteCharAt(sb.length-1)

            }
        }
    }
}

fun main() {
    val r = RemoveInvalidParentheses.removeInvalidParentheses("((I)")
    r.forEach(::println)
}