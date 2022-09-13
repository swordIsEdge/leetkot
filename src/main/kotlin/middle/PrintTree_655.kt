package middle

import common.TreeNode

object PrintTree_655 {
    fun printTree(root: TreeNode?): List<List<String>> {
        val height = getHeight(root)
        val col = height
        val row = (1 shl height) - 1
        val result = MutableList(col) { MutableList(row) { "" } }
        fill(root, 0, 0, row-1, result)
        return result
    }
    fun fill(root: TreeNode?, ind: Int, start: Int, end: Int, result: MutableList<MutableList<String>>) {
        if (root == null) return
        else {
            val mid = (start+end) shr 1
            result[ind][mid] = root.`val`.toString()
            fill(root.left,ind+1,start,mid-1,result)
            fill(root.right,ind+1,mid+1,end,result)
        }
    }
    fun getHeight(root: TreeNode?): Int {
        return root?.let { maxOf(getHeight(root.left), getHeight(root.right)) + 1 } ?: 0
    }
}
