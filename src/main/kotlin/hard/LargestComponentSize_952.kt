package hard

import common.printSelf

object LargestComponentSize_952 {
    class UnionFind {
        val rank = IntArray(100001)
        val parent = IntArray(100001) { it }
        fun find(value: Int): Int {
            var next = value
            while (parent[next] != next) {
                next = parent[next]
            }
            return next
        }

        fun union(a: Int, b: Int) {
//            println("merge $a $b")
            val fa = find(a)
            val fb = find(b)
            if (fa != fb) {
                if (rank[fa] > rank[fb]) {
                    parent[fb] = fa
                } else {
                    parent[fa] = fb
                    if (rank[fa] == rank[fb]) {
                        rank[fb]++
                    }
                }
            }
        }
    }

    fun largestComponentSize(nums: IntArray): Int {
        val uf = UnionFind()
        for (num in nums) {
            var start = 2
            while (start <= num / start) {
                if (num % start == 0) {
                    uf.union(num, start)
                    uf.union(num, num / start)
                }
                start++
            }
        }
        val map = hashMapOf<Int, Int>()
        val ps = nums.map { uf.find(it) }
        val ps2 = ps.associateWithTo(map) { map.getOrDefault(it, 0) + 1 }
        return ps2.values.max()!!
    }
}

fun main() {
    val res = LargestComponentSize_952.largestComponentSize(
        intArrayOf(4, 6, 15, 35)
    )
    res.printSelf()
}