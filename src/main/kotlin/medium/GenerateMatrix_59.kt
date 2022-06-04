package medium

object Generateresult_59 {
    fun generateresult(n: Int): Array<IntArray> {
        val result = Array(n) { IntArray(n) { 0 } }
        val h = n
        val w = n

        var up = 0
        var down = h - 1
        var left = 0
        var right = w - 1
        var tmp = 1
        while (up <= down && left <= right) {
            for (j in left..right) {
                result[up][j] = tmp++
            }
            for (i in up + 1 until down) {
                result[i][right] = tmp++
            }
            if (up != down) {
                for (j in right downTo left) {
                    result[down][j] = tmp++
                }
            }
            if (left != right) {
                for (i in down - 1 downTo up + 1) {
                    result[i][left] = tmp++
                }
            }
            up++
            down--
            left++
            right--
        }
        return result
    }
}