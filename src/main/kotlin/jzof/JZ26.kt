package jzof

import common.TreeNode
import common.buildTreeNode

object JZ26 {
    var result = false
    fun HasSubtree(pRoot1: TreeNode?, pRoot2: TreeNode?): Boolean {
        // write code here
        if (pRoot1 == null) {
            return false
        }
        walk(pRoot1, pRoot2)
        return result
    }

    fun walk(pRoot1: TreeNode?, pRoot2: TreeNode?) {
        if (result) {
            return
        }
        if (pRoot1 == null || pRoot2 == null) {
            return
        }
        if (pRoot1.`val` == pRoot2.`val`) {
            result = verify(pRoot1, pRoot2)
        }
        walk(pRoot1.left, pRoot2)
        walk(pRoot1.right, pRoot2)
    }

    fun verify(pRoot1: TreeNode?, pRoot2: TreeNode?): Boolean {
        return if (pRoot1 == null && pRoot2 == null) {
            true
        } else if (pRoot1 == null) {
            false
        } else if (pRoot2 == null) {
            true
        } else {
            if (pRoot1.`val` == pRoot2.`val`) {
                verify(pRoot1.left, pRoot2.left) && verify(pRoot1.right, pRoot2.right)
            } else {
                false
            }
        }
    }
}

fun main() {
    val f = buildTreeNode(listOf(1, 2, 3))
    val s = buildTreeNode(listOf(2, 3, null))
    val res = JZ26.HasSubtree(f, s)
    print(res)
}