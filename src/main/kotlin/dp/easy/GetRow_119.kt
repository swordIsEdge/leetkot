package dp.easy

object GetRow_119 {
    fun getRow(rowIndex: Int): List<Int> {
        if (rowIndex == 0) return listOf(1)
        val result = MutableList(rowIndex + 1) { 1 }
        for (i in 1..rowIndex) {
            var last = 1
            var cur = 1
            for (j in 1 until i) {
                cur = result[j]
                result[j] = last+cur
                last = cur
            }
        }
        return result
    }
}