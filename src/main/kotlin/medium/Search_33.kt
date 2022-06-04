package medium

object Search_33 {
    fun search(nums: IntArray, target: Int): Int {
        if (target == nums[0]) return 0
        if (target == nums[nums.size - 1]) return nums.size - 1
        var i = 1
        var j = nums.size - 1
        val endFlag = nums[nums.size - 1]
        while (i <= j) {

            val medium = (i + j) / 2
            val mediumValue = nums[medium]

            if (mediumValue == target) {
                return medium
            } else if (target < mediumValue) {
                if (mediumValue < endFlag) {
                    j = medium - 1
                } else {
                    if (target < endFlag) {
                        i = medium + 1
                    } else {
                        j = medium - 1
                    }
                }
            } else { //target>mediumValue
                if (mediumValue > endFlag) {
                    i = medium + 1
                } else {
                    if (target > endFlag) {
                        j = medium - 1
                    } else {
                        i = medium + 1
                    }
                }
            }
        }
        return -1
    }
}

fun main() {
    val res = Search_33.search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0)
    println(res)
}