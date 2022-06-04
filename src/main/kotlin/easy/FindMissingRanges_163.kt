package easy

object FindMissingRanges_163 {
    fun findMissingRanges(nums: IntArray, lower: Int, upper: Int): List<String> {
        var last = lower
        val result = mutableListOf<String>()

        for (n in nums) {
            if (last < n) {
                val start = last
                val end = n-1
                if (start == end) {
                    result.add(start.toString())
                } else {
                    result.add("$start->$end")

                }
            }
            last = n+1
        }
        if (last <= upper) {
            val start = last
            val end = upper
            if (start == end) {
                result.add(start.toString())
            } else {
                result.add("$start->$end")
            }
        }
        return result
    }
}

fun main() {
    val r = FindMissingRanges_163.findMissingRanges(intArrayOf(), 1, 1)
    for (s in r) {
        println(s)
    }
}