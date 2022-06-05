package middle

import kotlin.random.Random

class RandPoint(radius: Double, x_center: Double, y_center: Double) {
    val radius = radius
    val radiusSquare = radius*radius
    val xCenter = x_center
    val yCenter = y_center


    fun randPoint(): DoubleArray {
        while (true) {
            val x = Random.nextDouble(-radius, radius)
            val y = Random.nextDouble(-radius, radius)
            if (x * x + y * y <= radiusSquare){
                return doubleArrayOf(xCenter+x,yCenter+y)
            }
        }
    }

}