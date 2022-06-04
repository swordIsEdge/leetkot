package easy

object HammingDistance_461 {
    fun hammingDistance(x: Int, y: Int): Int {
        var xorResult = x xor y
        var count = if (xorResult and 0x1 != 0) 1 else 0
        for (i in 1..31) {
            xorResult = xorResult ushr 1
            count+=if (xorResult and 0x1 != 0) 1 else 0

        }
        return count
    }
}