package middle

object Exist_79 {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        if (board.isEmpty() && word.isEmpty()) return true
        if (board.isEmpty()) return false
        val h = board.size
        val w = board[0].size

        val flag = Array(h) { BooleanArray(w) { false } }
        for (i in 0 until h) {
            for (j in 0 until w) {
                if (dfs(board, flag, word, 0,h,w,i,j)) {
                    return true
                }
            }
        }
        return false
    }

    fun dfs(
        board: Array<CharArray>,
        flag: Array<BooleanArray>,
        word: String,
        index: Int,
        h: Int,
        w: Int,
        i: Int,
        j: Int
    ): Boolean {
        if (index >= word.length) return true
        if (i < 0 || j < 0 || i >= h || j >= w) return false
        if (board[i][j] != word[index]) return false
        if (flag[i][j]) {
            return false
        }
        flag[i][j] = true
        val next = dfs(board, flag, word, index + 1, h, w, i - 1, j) || dfs(
            board,
            flag,
            word,
            index + 1,
            h,
            w,
            i,
            j - 1
        ) || dfs(board, flag, word, index + 1, h, w, i + 1, j) || dfs(board, flag, word, index + 1, h, w, i, j + 1)
        flag[i][j] = false
        return next
    }
}