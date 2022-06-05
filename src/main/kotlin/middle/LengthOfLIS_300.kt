package middle

object LengthOfLIS_300 {
    fun lengthOfLIS(nums: IntArray): Int {
        val tail = IntArray(nums.size)
        var result = 0
        for (num in nums) {
            var i = 0
            var j = result

            while (i < j) {  //1
                val m = (i + j) / 2
                val medium = tail[m]
                if (medium < num) i = m +1 //2
                else j = m //3
            }
            tail[i] = num
            if (j == result) result++
        }
        return result
    }
}

fun main() {
    val r = LengthOfLIS_300.lengthOfLIS(intArrayOf(0,1,0,3,2,3))
    println(r)
}