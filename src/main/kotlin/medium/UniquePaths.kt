package medium

object UniquePaths {
    fun uniquePaths(m: Int, n: Int): Int {
        if (m == 0 || n == 0) return 0
        var dp = IntArray(n) { 1 }
        var next = IntArray(n)
        next[0] = 1
        for(k in 1 until m){
            for(i in 1 until n){
                next[i] = next[i-1]+dp[i]
            }
            dp = next
            next = IntArray(n)
            next[0]=1
        }
        return dp[n - 1]

    }
}