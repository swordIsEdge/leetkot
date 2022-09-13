//generateSequence(1) { if (it < 3) it else null }.toList()
fun get(nums: IntArray, mid: Int): Int {
    var res = 0;
    var i = 0
    var j = 0
    while (i < nums.size) {
        while (nums[i] - nums[j] > mid) j++
        res += i - j
        println("$j->$i = ${i-j}")

        i++
    }
    return res;
}
get(intArrayOf(0,1,2,3),3)






