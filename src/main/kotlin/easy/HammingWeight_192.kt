package easy

object HammingWeight_192 {
    fun hammingWeight(n:Int):Int {
        var count = 0
        val base = 1
        for (i in 0..31) {
            if((base shl i) and n !=0) count++
        }
        return count
    }
}