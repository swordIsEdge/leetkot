package easy

object PlusOne_66 {
    fun plusOne(digits: IntArray): IntArray {
        var remain = 0
        val len = digits.size
        if (len == 0) return digits
        val tmp = digits[len - 1]+1
        digits[len - 1] = tmp % 10
        remain = tmp / 10
        for (i in digits.size - 2 downTo 0) {
            val cur = digits[i]+remain
            digits[i] = cur % 10
            remain = cur / 10
            if (remain == 0) {
                return digits
            }
        }
        if (remain != 0) {
            return intArrayOf(remain).plus(digits)
        } else {
            return digits
        }
    }
}