package dp.easy

object Fib_offer_10 {
    fun fib(n: Int): Int {
        if(n<=1) return n
        var i = 0
        var j = 1
        var cur = 1
        for (ind in 2..n) {
            cur = (i+j)%1000000007
            i = j
            j = cur
        }
        return cur
    }
}