package medium

class NumIslands_200 {
    fun numIslands(grid: Array<CharArray>): Int {
        if (grid.isEmpty()) return 0
        val h = grid.size
        val w = grid[0].size
        var count = 0
        val visited = Array(h) { BooleanArray(w) { false } }
        for (i in grid.indices) {
            for (j in 0 until w) {
                if (!visited[i][j]) {
                    if (grid[i][j] == '1') {
                        count++
                        dfs(grid, h, w, i, j, visited)
                    }
                }
            }
        }
        return count
    }

    fun dfs(grid: Array<CharArray>, h: Int, w: Int, i: Int, j: Int, visited: Array<BooleanArray>) {
        if (i < 0 || j < 0 || i >= h || j >= w) {
            return
        }
        if (visited[i][j]) {
            return
        }
        visited[i][j] = true

        val c = grid[i][j]
        if (c == '0') {
            return
        } else {
            dfs(grid,h,w,i-1,j,visited)
            dfs(grid,h,w,i,j-1,visited)
            dfs(grid,h,w,i+1,j,visited)
            dfs(grid,h,w,i,j+1,visited)
        }
    }
}