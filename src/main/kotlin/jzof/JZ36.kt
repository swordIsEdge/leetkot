package jzof

import common.TreeNode
import common.buildTreeNode

object JZ36 {
    fun Convert(pRootOfTree: TreeNode?): TreeNode? {
        // write code here
        if (pRootOfTree == null) {
            return null
        }
        val left = addToLeft(pRootOfTree, pRootOfTree.left)
        addToRight(pRootOfTree, pRootOfTree.right)
        return left
    }

    fun addToLeft(master: TreeNode, saber: TreeNode?): TreeNode {
        if (saber == null) {
            return master
        }
        val preLeft = master.left

        val preSaberLeft = saber.left
        val preSaberRight = saber.right

        master.left = saber
        saber.right = master

        if (saber != preLeft) {
            saber.left = preLeft
            preLeft?.let { it.right = saber }

        }

        val nextLeft = addToLeft(saber, preSaberLeft)
        addToRight(saber, preSaberRight)
        return nextLeft
    }

    fun addToRight(master: TreeNode, saber: TreeNode?) {
        if (saber == null) {
            return
        }
        val preRight = master.right

        val preSaberLeft = saber.left
        val preSaberRight = saber.right

        master.right = saber
        saber.left = master
        if (preRight != saber) {
            saber.right = preRight
            preRight?.let { it.left = saber }
        }
        addToLeft(saber, preSaberLeft)
        addToRight(saber, preSaberRight)
    }
}

fun main() {
    val result = JZ36.Convert(buildTreeNode(listOf(10, 6, 14, 4, 8, 12, 16)))
}