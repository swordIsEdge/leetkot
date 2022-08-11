package dataStructure

class SegTree(val n: Int) {
    val tree: IntArray
    val mark: IntArray

    init {
        tree = IntArray(n shl 1)
        mark = IntArray(n shl 1)
    }


    fun build(arr: IntArray, left: Int, right: Int, index: Int) {
        if (left == right) {
            tree[left] = arr[left]
        } else {
            val mid = (left + right) shr 1
            this.build(arr, left, mid, index shl 1)
            this.build(arr, mid + 1, right, (index shl 1) or 1)
            tree[index] = tree[index shl 1] + tree[(index shl 1) or 1]
        }
    }

    fun push_down(index: Int, len: Int) {
        if (len <= 1) return
        val left = index shl 1
        val right = (index shl 1) or 1
        tree[left] += mark[index]
        mark[left] += mark[index]

        tree[right] += mark[index]
        mark[right] += mark[index]

        mark[index] = 0
    }

    fun update(updateLeft: Int, updateRight: Int, value: Int, index: Int = 0, localLeft: Int, localRight: Int) {
        if (updateLeft <= localLeft && localRight <= updateRight) {
            mark[index] += value
            tree[index] += value
        } else {
            push_down(index, localRight - localLeft + 1)
            val mid = (localLeft + localRight) shr 1
            if (mid >= updateLeft) { // 左半区间需要更新
                update(updateLeft, updateRight, value, index shl 1, localLeft, mid)
            }
            if (mid < updateRight) {
                update(updateLeft, updateRight, value, (index shl 1) or 1, mid + 1, localRight)
            }
            tree[index] = tree[index shl 1] + tree[(index shl 1) or 1]
        }
    }

    fun query(queryStart: Int, queryEnd: Int, index: Int, localLeft: Int, localRight: Int): Int {
        if (queryStart <= localLeft && localRight <= queryEnd) return tree[index]
        val mid = (localLeft + localRight) shr 1
        var ans = 0
        push_down(index, localRight - localLeft + 1)
        if (mid >= queryStart) {
            ans += query(queryStart, queryEnd, index shl 1, localLeft, mid)
        }
        if (mid < queryEnd) {
            ans += query(queryStart, queryEnd, (index shl 1) or 1, mid + 1, localRight)
        }
        return ans
    }

    companion object {
        fun build(arr: IntArray): SegTree {
            val obj = SegTree(arr.size)
            obj.build(arr, 0, arr.size - 1, 0)
            return obj
        }
    }
}
//https://zhuanlan.zhihu.com/p/34150142
//https://zhuanlan.zhihu.com/p/106118909