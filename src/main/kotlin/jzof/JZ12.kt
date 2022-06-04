package jzof

object JZ12 {
    fun hasPath(matrix: Array<CharArray>, word: String): Boolean {
        val h = matrix.size
        val w = matrix[0].size

        val wordChar = word.toCharArray()
        val flags = Array(h) { BooleanArray(w) { false } }
        for (i in 0 until h) {
            for (j in 0 until w) {
                if (matrix[i][j] == wordChar[0]) {
                    flags[i][j] = true
                    val tmpResult = dfs(1, flags, wordChar, matrix, i, j, h, w)
                    if (tmpResult) {
                        return true
                    }
                    flags[i][j] = false
                }
            }
        }
        return false
    }

    private fun dfs(
        index: Int,
        flags: Array<BooleanArray>,
        chars: CharArray,
        matrix: Array<CharArray>,
        i: Int,
        j: Int,
        h: Int,
        w: Int
    ): Boolean {
        if (index == chars.size) {
            return true
        }
        val value = chars[index]
        if (i > 0 && !flags[i - 1][j]) {
            val up = matrix[i - 1][j]
            if (up == value) {
                flags[i - 1][j] = true
                val next = dfs(index + 1, flags, chars, matrix, i - 1, j, h, w)
                if (next) {
                    return true
                }
                flags[i - 1][j] = false
            }
        }

        if (i < h - 1 && !flags[i + 1][j]) {
            val down = matrix[i + 1][j]
            if (down == value) {
                flags[i + 1][j] = true
                val next = dfs(index + 1, flags, chars, matrix, i + 1, j, h, w)
                if (next) {
                    return true
                }
                flags[i + 1][j] = false
            }
        }
        if (j > 0 && !flags[i][j - 1]) {
            val left = matrix[i][j - 1]
            if (left == value) {
                flags[i][j - 1] = true
                val next = dfs(index + 1, flags, chars, matrix, i, j - 1, h, w)
                if (next) {
                    return true
                }
                flags[i][j - 1] = false
            }
        }
        if (j < w - 1 && !flags[i][j + 1]) {
            val right = matrix[i][j + 1]
            if (right == value) {
                flags[i][j + 1] = true
                val next = dfs(index + 1, flags, chars, matrix, i, j + 1, h, w)
                if (next) {
                    return true
                }
                flags[i][j + 1] = false
            }
        }
        return false
    }
}