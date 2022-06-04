package easy

object ClimbStairs_70 {
    fun climbStairs(n: Int): Int {
        if (n <= 2) {
            return n
        }
        var f1 = 1
        var f2 = 2
        var result = 3
        for(i in 3..n){
            result = f1+f2
            f1 = f2
            f2 = result
        }
        return result
    }
}