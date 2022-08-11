package dp.middle

import common.printSelf

object MinimumBuckets_2086 {
    fun minimumBuckets(street: String): Int {
        val len = street.length
        val neibor = IntArray(len)
        for ((i, c) in street.withIndex()) {
            if (c == '.') {
                neibor[i] = 0
            } else if (i == 0) {
                if (i == len - 1) {
                    return -1
                } else {
                    neibor[i] = if (street[i + 1] == '.') 1 else return -1
                }
            } else if (i == len - 1) {
                neibor[i] = if (neibor[i - 1] == 0) 1 else return -1
            } else {
                neibor[i] += if (street[i - 1] == '.') 1 else 0
                neibor[i] += if (street[i + 1] == '.') 1 else 0
                if (neibor[i] == 0) return -1
            }
        }

        val result = BooleanArray(len)
        for ((i, c) in neibor.withIndex()) {
            if (c == 1) {
                if (i > 0) {
                    if (street[i - 1] == '.') {
                        result[i - 1] = true
                        neibor[i] = 0
                        if (i - 2 > 0) {
                            neibor[i - 2] = 0
                        }
                    }
                }
                if (i < len-1) {
                    if (street[i + 1] == '.') {
                        result[i + 1] = true
                        neibor[i] = 0
                        if (i + 2 < len) {
                            neibor[i + 2] = 0
                        }
                    }
                }
            }
        }
        for ((i, c) in neibor.withIndex()) {
            if (c == 2) {
                result[i + 1] = true
                if (i + 2 < len && neibor[i + 2] == 2) {
                    neibor[i + 2] = 0
                }
            }
        }
        return result.filter { it }.size
    }
}

fun main() {
    val s = "H..H"
    val res = MinimumBuckets_2086.minimumBuckets(s)
    res.printSelf()
}