package dp.middle

object IntegerReplacement_397 {
    fun integerReplacement(n: Int): Int {
        return if (n == 1) 0
        else if (n == 2) 1
        else if (n % 2 == 0) 1 + integerReplacement(n / 2)
        else if (n == Int.MAX_VALUE) 1 + minOf( integerReplacement(n - 1),1+ integerReplacement(1073741824))
        else 1 + minOf(integerReplacement(n + 1), integerReplacement(n - 1))
    }
}