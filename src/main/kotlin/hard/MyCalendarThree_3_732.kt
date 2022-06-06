package hard

object MyCalendarThree_3_732 {
    val tree = hashMapOf<Int, Int>()
    val lazy = hashMapOf<Int, Int>()
    fun book(start: Int, end: Int): Int {
        update(start, end - 1, 0, 1000000000, 1)
        return tree.getOrDefault(1, 0)
    }

    fun update(start: Int, end: Int, l: Int, r: Int, ind: Int) {
        if (end < l || start > r) {
            return
        }

        if (start <= l && end >= r) {
            tree[ind] = (tree[ind] ?: 0) + 1
            lazy[ind] = (lazy[ind] ?: 0) + 1
        } else {
            val mid = (l + r) / 2
            update(start,end,l,mid,ind*2)
            update(start,end,mid+1,r,ind*2+1)

            tree[ind] = lazy.getOrDefault(ind, 0) + maxOf(tree[ind * 2] ?: 0, tree[ind * 2 + 1] ?: 0)
        }
    }

}