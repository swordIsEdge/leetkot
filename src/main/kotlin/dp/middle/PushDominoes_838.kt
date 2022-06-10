package dp.middle

object PushDominoes_838 {
    fun pushDominoes(dominoes: String): String {
        val result = StringBuilder()
        for (index in dominoes.indices) {
            val c = dominoes[index]
            if (c == '.') {
                var left = if (index > 0) dominoes[index - 1] else '.'
                if (left == 'L') left = '.'
                var right = if (index < dominoes.length - 1) dominoes[index + 1] else '.'
                if (right == 'R') right = '.'
                if (left == '.' && right == '.') {
                    result.append(c)
                } else if (left == '.') {
                    if (right == 'L') result.append('L')
                    else result.append(c)
                } else if (right == '.') {
                    if (left == 'R') result.append('R')
                    else result.append(c)
                } else {
                    result.append(c)
                }
            } else {
                result.append(c)
            }
        }
        return result.toString()
    }
}

fun main() {
    print( PushDominoes_838.pushDominoes(".L.R...LR..L.."))
}