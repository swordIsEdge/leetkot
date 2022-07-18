package middle

import kotlin.math.abs

class AsteroidCollision_735_old {
    fun asteroidCollision(asteroids: IntArray): IntArray {
        var ast = asteroids
        while (canCollide(ast)) {
            ast = afterCollide(ast)
        }
        return ast
    }

    fun afterCollide(a: IntArray): IntArray {
        val len = a.size
        val next = mutableListOf<Int>()
        var index = 0
        while (a[index] < 0) {
            next.add(a[index++])
        }
        var start = index

        val positiveStack = mutableListOf<Int>()
        val negativeStack = mutableListOf<Int>()
        while (true) {
            positiveStack.clear()
            negativeStack.clear()
            // 构造两个单调栈
            while (index < len && a[index] > 0) {
                while (positiveStack.isNotEmpty() && a[positiveStack.last()] < a[index]) {
                    positiveStack.removeLast()
                }
                positiveStack.add(index++)
            }
            while (index < len && a[index] < 0) {
                while (negativeStack.isNotEmpty() && a[negativeStack.last()] > a[index]) {
                    negativeStack.removeLast()
                }
                negativeStack.add(index++)
            }
            if (positiveStack.isNotEmpty() && negativeStack.isNotEmpty()) {
                val maxP = a[positiveStack.first()]
                val maxN = abs(a[negativeStack.first()])
                if (maxP == maxN) {


                }else if (maxP < maxN) {

                } else {

                }

                start = index


            }

            if (index >= len) {
                break
            }
        }

        for (i in start until a.size) {
            next.add(a[i])
        }
        return next.toIntArray()
    }


    fun canCollide(asteroids: IntArray): Boolean {
        val index1 = asteroids.find { it > 0 }
        val index2 = asteroids.findLast { it < 0 }
        return if (index1 != null && index2 != null) {
            index1 < index2
        } else {
            false
        }
    }
}