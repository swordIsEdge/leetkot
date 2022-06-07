package easy

object IsBoomerang_1037 {
    data class P(val x: Int, val y: Int)

    fun isBoomerang(points: Array<IntArray>): Boolean {
        if (points.size < 3) return false
        val ps = points.map { P(it[0], it[1]) }.toHashSet().toList()
        val len = ps.size
        for (i in 0..len - 3) {
            for (j in i + 1..len - 2) {
                for (k in j + 1..len - 1) {
                    if (!isSameLine(ps[i], ps[j], ps[k])) {
                        return true
                    }
                }
            }
        }
        return false
    }

    fun isSameLine(p1: P, p2: P, p3: P) = (p1.x - p3.x) * (p1.y - p2.y) == (p1.y - p3.y) * (p1.x - p2.x)

}