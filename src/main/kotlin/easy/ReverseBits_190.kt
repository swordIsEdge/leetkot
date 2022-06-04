package easy

object ReverseBits_190 {
    fun reverseBits(n:Int):Int {
        val base = 1
        var result = 0
        for (i in 0..31) {
            result = result shl 1
            if ((base shl i) and n != 0) {
                result = result or 1
            }
        }
        return result
    }
}