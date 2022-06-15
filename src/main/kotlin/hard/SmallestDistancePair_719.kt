package hard

import java.util.*

object SmallestDistancePair_719 {
    data class Node(
        val i: Int,
        val j: Int,
        val value: Int
    )

    fun smallestDistancePair(nums: IntArray, k: Int): Int {
        Arrays.sort(nums)
        val diffs = nums.mapIndexed { index, i -> if (index == 0) 0 else i - nums[index - 1] }.subList(1, nums.size)
        val diffLen = diffs.size
        val visited = Array(diffLen) { BooleanArray(diffLen) }
        val heap = PriorityQueue<Node> { node1, node2 -> node1.value.compareTo(node2.value) }
        for (i in 0 until diffLen) {
            visited[i][i] = true
            heap.add(Node(i, i, diffs[i]))
        }
        for (i in  1 until k) {
            val (i, j, value) = heap.poll()
            if (i > 0 && !visited[i - 1][j]) {
                visited[i - 1][j] = true
                heap.add(Node(i - 1, j, value + diffs[i - 1]))

            }
            if (j < diffLen - 1 && !visited[i][j + 1]) {
                visited[i][j + 1] = true
                heap.add(Node(i, j + 1, value + diffs[j + 1]))
            }
        }
        return heap.poll().value
    }
}