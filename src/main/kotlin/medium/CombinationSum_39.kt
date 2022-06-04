package medium

object CombinationSum_39 {
    val result = mutableListOf<List<Int>>()
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        dfs(candidates,0,0,target, listOf())
        return result
    }

    fun dfs(candidates: IntArray, index: Int, sum: Int, tgt: Int, tmp: List<Int>) {
        if (index >= candidates.size || sum > tgt) {
            return
        }
        val num = candidates[index]
        var sum = sum
        var nt = tmp
        while (sum < tgt) {
            dfs(candidates, index + 1, sum, tgt, nt)
            sum += num
            nt = nt.plus(num)
        }
        if (sum == tgt) {
            result.add(nt)
        }
    }
}

fun main() {
    val res = CombinationSum_39.combinationSum(intArrayOf(2), 1)
    for (re in res) {
        for (i in re) {
            print("$i->")
        }
        println()
    }
}