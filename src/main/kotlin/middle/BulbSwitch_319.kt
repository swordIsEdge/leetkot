package middle

import kotlin.math.floor
import kotlin.math.sqrt

object BulbSwitch_319 {
    fun bulbSwitch(n: Int): Int {
        val res = sqrt(n.toDouble())
        return floor(res).toInt()
    }
}