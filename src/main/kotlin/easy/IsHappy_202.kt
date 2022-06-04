package easy

object IsHappy_202 {
    fun isHappy(n: Int): Boolean {
        if (n == 1) return true
        val visited = hashSetOf<Int>()
        visited.add(n)
        var x = n
        while (x != 1) {
            x = squareAndAdd(x)
            if (x in visited) {
                return false
            }
            visited.add(x)
        }
        return true
    }

    fun squareAndAdd(n: Int): Int {
        var x = n
        var sum = 0
        while (x > 0) {
            sum += (x % 10) * (x % 10)
            x = x / 10
        }
        return sum
    }
}

fun main() {
    println(IsHappy_202.isHappy(2))
}