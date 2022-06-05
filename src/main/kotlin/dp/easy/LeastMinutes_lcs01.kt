package dp.easy

import kotlin.math.ceil
import kotlin.math.log

object LeastMinutes_lcs01 {
    fun leastMinutes(n: Int): Int {
        if (n <= 1) {
            return n
        }
       return ceil(log(n*1.0,2.0)).toInt()+1

    }
}