package jzof

object JZ33 {
    fun VerifySquenceOfBST(sequence: IntArray): Boolean  {
        // write code here
        if (sequence.isEmpty()) {
            return false
        }
        return verify(sequence,0,sequence.size-1)
    }
    fun verify(array: IntArray, start: Int, end: Int): Boolean {
        if (start >= end) {
            return true
        }
        val flag = array[end]
        var before = array[start] < flag
        var index = start
        for (i in start until end) {
            if (before) {
                if (array[i] >= flag) {
                    before = false
                    index = i
                }
            }else if (array[i] < flag) {
                return false
            }
        }
        return verify(array, start, index - 1) && verify(array, index, end-1)

    }
}

fun main() {
    val res = JZ33.VerifySquenceOfBST(intArrayOf(1, 3, 2))
    print(res)
}