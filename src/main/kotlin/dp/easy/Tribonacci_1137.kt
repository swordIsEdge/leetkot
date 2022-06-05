package dp.easy

object Tribonacci_1137 {
    fun tribonacci(n: Int): Int {
        return when (n) {
            0->0
            1->1
            2->1
            else->{
                var result = 2
                var i = 0
                var j = 1
                var k = 1
                for (ind in 3..n) {
                    result = i+j+k

                    i = j
                    j = k
                    k = result
                }
                return result
            }
        }
    }
}