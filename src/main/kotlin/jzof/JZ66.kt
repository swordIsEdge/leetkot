package jzof

object JZ66 {
    fun multiply(A: IntArray): IntArray {
        // write code here
        val left = IntArray(A.size) { 1 }
        val right = IntArray(A.size) { 1 }
        left[0] = A[0]
        for (i in 1 until A.size) {
            left[i] = left[i - 1] * A[i]
        }
        right[A.size - 1] = A[A.size - 1]
        for (i in A.size - 2 downTo 0) {
            right[i] = right[i + 1] * A[i]
        }
        val result = IntArray(A.size) { 1 }
        result[0] = right[1]
        result[A.size - 1] = left[A.size - 2]
        for (i in 1..A.size - 2) {
            result[i] = left[i - 1] * right[i + 1]
        }
        return result
    }
}

fun main() {
    JZ66.multiply(intArrayOf(1, 2, 3, 4))
}