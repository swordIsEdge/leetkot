package middle

import java.util.LinkedList

class NestedIterator_341(nestedList: List<NestedInteger>) {
    val result = mutableListOf<Int>()
    var index = 0
    init {
        val stack = LinkedList<NestedInteger>()
        for (nestedInteger in nestedList) {
            stack.push(nestedInteger)
            while (stack.isNotEmpty()) {
                val item = stack.pop()
                if (item.isInteger()) {
                    result.add(item.getInteger()!!)
                } else {
                    val ls = item.getList()
                    ls?.reversed()?.forEach{stack.push(it)}
                }
            }
        }

    }



    fun next(): Int {
        return result[index++]
    }

    fun hasNext(): Boolean {
        return index<result.size
    }
}



  // This is the interface that allows for creating nested lists.
  // You should not implement it, or speculate about its implementation
  abstract class NestedInteger {
      // Constructor initializes an empty nested list.
      constructor()
 
      // Constructor initializes a single integer.
      constructor(value: Int)
 
      // @return true if this NestedInteger holds a single integer, rather than a nested list.
      abstract fun isInteger(): Boolean
 
      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      abstract fun getInteger(): Int?
 
      // Set this NestedInteger to hold a single integer.
      abstract fun setInteger(value: Int): Unit
 
      // Set this NestedInteger to hold a nested list and adds a nested integer to it.
      abstract fun add(ni: NestedInteger): Unit
 
      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return null if this NestedInteger holds a single integer
      abstract fun getList(): List<NestedInteger>?
  }
