package easy

object CanBeEqual_1460 {
    fun canBeEqual(target: IntArray, arr: IntArray): Boolean {
        val counter = IntArray(1001)
        target.forEach { counter[it]++ }
        arr.forEach {
            counter[it]--
            if (counter[it] < 0) {
                return false
            }
        }
        return true
    }
}