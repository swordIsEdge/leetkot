package middle

import common.TreeNode

object BuildTree_105 {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        if (preorder.isEmpty()) {
            return null
        }
        return buildTree(preorder, 0, preorder.size - 1, inorder, 0, inorder.size - 1)
    }

    fun buildTree(
        preorder: IntArray,
        preStart: Int,
        preEnd: Int,
        inorder: IntArray,
        inStart: Int,
        inEnd: Int
    ): TreeNode? {
        if (preStart > preEnd) return null
        if (preStart == preEnd) return TreeNode(preorder[preStart])
        val tmp = preorder[preStart]

        var inIndex = inStart
        for (i in inStart..inEnd) {
            if (inorder[i] == tmp) {
                inIndex = i
                break
            }
        }
        val leftLen = inIndex - inStart
        val left = buildTree(preorder, preStart + 1, preStart + leftLen, inorder, inStart, inIndex - 1)
        val right = buildTree(preorder, preStart + leftLen + 1, preEnd, inorder, inIndex + 1, inEnd)
        val node = TreeNode(tmp)
        node.left = left
        node.right = right
        return node
    }
}