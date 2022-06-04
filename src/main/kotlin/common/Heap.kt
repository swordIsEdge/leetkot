package common

class Heap {
    var count = 0
    var array = IntArray(100) { 0 }
    fun add(num: Int) {
//        count++
//        if (count >= array.size) {
//            array = array.copyOf(2 * array.size)
//        }
        offer(num, count)
        count++
    }

    private fun offer(num: Int, k: Int) {
        var k = k
        while (k > 0) {
            val p = (k - 1) ushr 1
            val e = array[p]
            if (num >= e) {
                break
            }
            array[k] = e
            k = p
        }
        array[k] = num
    }

    fun peek(): Int {
        return array[0]
    }

    fun poll(): Int {
        TODO()
    }
}