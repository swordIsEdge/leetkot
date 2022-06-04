package common

fun preOrder(root: TreeNode) {
    println(root.`val`)
    root.left?.let { preOrder(it) }
    root.right?.let { preOrder(it) }
}
fun postOrder(root: TreeNode) {
    root.left?.let { preOrder(it) }
    root.right?.let { preOrder(it) }
    println(root.`val`)
}
fun mediumOrder(root: TreeNode) {
    root.left?.let { preOrder(it) }
    println(root.`val`)
    root.right?.let { preOrder(it) }
}

