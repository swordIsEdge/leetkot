package jzof

object JZ46 {
    fun solve(nums: String): Int {
        // write code here
        val ca = nums.toCharArray()
        val ints = ca.map { it - '0' }.toIntArray()
        return solve(ints, 0)
    }

    private fun solve(ints: IntArray, ind: Int): Int {
        return if (ind >= ints.size) 1
        else if (ints[ind] > 0) {
            solve(ints, ind + 1) + if (ind + 1 < ints.size) {
                val tmp = ints[ind] * 10 + ints[ind + 1]
                if (tmp <= 26) {
                    solve(ints, ind + 2)
                } else 0
            } else 0
        } else 0
    }
}

fun main() {
    val res = JZ46.solve("12")
    print(res)
}