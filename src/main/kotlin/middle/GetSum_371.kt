package middle

object GetSum_371 {
    fun getSum(a: Int, b: Int): Int {
        var result = 0
        var r = false
        val base = 1

        for (i in 0..31) {
            val f = a and (base shl i)!=0
            val s = b and (base shl i)!=0
            result = result or (if(f xor s xor r) (base shl i) else 0)
            r = (f and s) or (f and r) or (s and r)
        }
        return result
    }
}