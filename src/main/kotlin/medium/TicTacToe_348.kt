package medium


class TicTacToe_348(n: Int) {
    var colCount = intArrayOf()
    var rowCount = intArrayOf()
    var dia = 0
    var dia2 = 0
    var n = 0

    init {
        this.n = n
        this.colCount = IntArray(n) { 0 }
        this.rowCount = IntArray(n) { 0 }
    }

    fun move(row: Int, col: Int, player: Int): Int {
        val factor = if (player == 1) 1 else -1
        colCount[col] += factor
        rowCount[row] += factor
        if (row == col) dia += factor
        if (row + col == n - 1) dia2 += factor

        if (factor * colCount[col] == n) return player
        if (factor * rowCount[row] == n) return player
        if (factor * dia == n) return player
        if (factor * dia2 == n) return player
        return 0
    }
}

fun main() {
    val t = TicTacToe_348(2)
    t.move(0, 0, 2)
    t.move(0, 1, 1)
    val r = t.move(1, 1, 2)
    println(r)
}