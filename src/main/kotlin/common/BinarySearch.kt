package common

object BinarySearch {
    // 搜索最大的<tgt的坐标
    fun binary(nums: IntArray, tgt: Int): Int {
        var left = -1
        var right = nums.size
        var medium = 0
        var mIndex = 0
        while (left < right) {
            mIndex = (left + right) / 2
            medium =
                if (mIndex < 0) Int.MIN_VALUE
                else if (mIndex >= nums.size) Int.MAX_VALUE
                else nums[mIndex]
            if (medium <= tgt) {
                left = mIndex + 1
            } else {
                right = mIndex - 1
            }
        }
//        println("left ${nums[left]}  medium ${nums[medium]}  right ${nums[right]} tgt: $tgt")
        return right
    }

    fun CR(nums: IntArray, tgt: Int, midIndex: Int): Boolean {
        return nums[midIndex] >= tgt
    }

    fun CL(nums: IntArray, tgt: Int, midIndex: Int): Boolean {
        return nums[midIndex] < tgt

    }

    fun template(nums: IntArray, tgt: Int):Int {
        var left = 0
        var right = nums.size - 1
        while (left < right) {
            val mid = (left + right) / 2
//            println("$left $mid $right")
            if (CL(nums, tgt, mid)) {
                left = mid + 1
            } else if (CR(nums, tgt, mid)) {
                right = mid
            }
        }
        return right
    }

    fun findFirstBigger(nums: IntArray, tgt: Int): Int {
        for (index in nums.indices) {
            if (nums[index] == tgt) {
                return index
            }
        }
        return 0
    }
}

fun main() {
//    val nums = (1..10).toList().toIntArray().flatMap { IntArray(Random.nextInt(10)) { it }.toList()}.toIntArray()
    val nums = (1..10).map { it.repeat(it).toList() }.flatten().toIntArray()

//    val tgts = intArrayOf(3)
    val tgts = (1..10)
    for (tgt in tgts) {
        val result = BinarySearch.template(nums, tgt)
        val result2 = BinarySearch.findFirstBigger(nums, tgt)
        println("$result <--> $result2")
    }
}
