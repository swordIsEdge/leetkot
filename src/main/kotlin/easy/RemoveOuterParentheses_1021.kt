package easy

object RemoveOuterParentheses_1021 {
    fun removeOuterParentheses(s: String): String {
        var result = ""
        var start = 0
        var count = 0
        for ((index,c) in s.withIndex()) {
            if (c == '(') {
                count++
            } else {
                count--
                if (count == 0) {
                    result += removeOuter(s.substring(start,index+1))
                    start = index+1
                }
            }
        }
        return result
    }

    fun removeOuter(s: String) =
        if (s.length < 2) {
            s
        } else {
            s.substring(1,s.length-1)
        }

}