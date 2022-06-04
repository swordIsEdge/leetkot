package jzof

object JZ16 {
    fun Power(base: Double, exponent: Int): Double {
        // write code here
        return if (exponent > 0) pow(base, exponent) else 1.0 / pow(base, -exponent)
    }

    fun pow(base: Double, exponent: Int): Double {
        return if (exponent == 0) 1.0 else Power(base, exponent - 1) * base
    }
}