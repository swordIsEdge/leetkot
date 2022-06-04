package medium

object SortColors_75 {
    fun sortColors(nums: IntArray): Unit {
        if (nums.size <= 1) return
        var z = 0
        var f = 0
        var s = nums.size - 1
        while (z < nums.size && f < nums.size && s >= 0 && f <= s) {
            while (f < nums.size && nums[f] != 2) {
                if (nums[f] == 0) {
                    nums[f] = 1
                    nums[z++] = 0
                }
                f++
            }
            if (f >= nums.size) break
            //f必然指向2

            while (s >= 0 && nums[s] == 2) s--
            if (s < 0 || s <= f) break
            if (nums[s] == 1) {
                nums[s--] = 2
                nums[f++] = 1
            } else { // s指向0
                nums[f] = 0
                nums[s--] = 2
            }
        }
    }
}

fun main() {
    val result = intArrayOf(2,0,2,1,1,0)
             SortColors_75.sortColors(result)
    for (i in result) {
        println("$i->")
    }


}