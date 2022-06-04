package medium

object FindCelebrity_277 {
    fun findCelebrity(n: Int): Int {
        val maybe = BooleanArray(n){ true}

        for (i in 0 until n) {
            for (j in 0 until n) {
                if (i == j) {
                    continue
                }
                if (!maybe[j] && !maybe[i]) continue
                if (knows(i, j)) {
                    maybe[i] = false
                } else {
                    maybe[j] =false
                }
            }
        }
        for (i in maybe.indices) {
            if (maybe[i]) {
                return i
            }
        }
        return -1
    }

    fun knows(a: Int, b: Int): Boolean {
        TODO()
    }
}