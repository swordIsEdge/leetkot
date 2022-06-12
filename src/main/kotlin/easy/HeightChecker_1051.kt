package easy

object HeightChecker_1051 {
    fun heightChecker(heights: IntArray): Int {
        val count = IntArray(101) { 0 }
        heights.forEach { count[it]++ }
        var re = 0

        var index = 0
        for (h in heights) {
            while (count[index] == 0) {
                index++
            }
            if (h != index) {
                re++
            }
            count[index]--
        }


        return re

    }
}