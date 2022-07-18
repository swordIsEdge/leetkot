package middle

import kotlin.math.abs

class AsteroidCollision_735 {
    fun asteroidCollision0(asteroids: IntArray): IntArray {
        val stack = mutableListOf<Int>()

        outer@ for (ast in asteroids) {
            if (stack.isEmpty() || ast > 0) {
                stack.add(ast)
                continue
            } else {  // ast<0
                val tmpAbs = abs(ast)
                while (stack.isNotEmpty()) {
                    if (stack.last() < 0) {
                        stack.add(ast)
                        continue@outer
                    } else {
                        if (stack.last() < tmpAbs) {
                            stack.removeLast()
                        } else if (stack.last() > tmpAbs) {
                            continue@outer
                        } else {
                            stack.removeLast()
                            continue@outer
                        }
                    }
                }
                stack.add(ast)
            }
        }
        return stack.toIntArray()
    }

    fun asteroidCollision(asteroids: IntArray): IntArray {
        val stack = mutableListOf<Int>()
        for (asteroid in asteroids) {
            var alive = true
            while (alive && asteroid < 0 && stack.isNotEmpty() && stack[stack.size - 1] > 0) {
                alive = stack[stack.size - 1] < (-asteroid)
                if (stack[stack.size - 1] <= -asteroid) {
                    stack.removeAt(stack.size - 1)
                }
            }
            if (alive) {
                stack.add(asteroid)
            }
        }
        return stack.toIntArray()
    }
}