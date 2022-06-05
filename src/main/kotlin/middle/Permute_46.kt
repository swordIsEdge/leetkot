package middle

object Permute_46 {
    fun permute(nums: IntArray): List<List<Int>> {
        val visited = BooleanArray(nums.size) { false }
        val result = mutableListOf<List<Int>>()
        dfs(0,nums,visited,result, listOf())
        return result
    }

    fun dfs(index: Int, nums: IntArray, visited: BooleanArray, result: MutableList<List<Int>>, tmp: List<Int>) {
        if (index == nums.size) {
            result.add(tmp)
        }
        for (numIndex in nums.indices) {
            if (visited[numIndex]) continue
            visited[numIndex] = true
            dfs(index + 1, nums, visited, result, tmp + nums[numIndex])
            visited[numIndex] = false
        }
    }
}