package jzof

object JZ44 {
    fun findNthDigit(n: Int): Int {
        if (n <= 9) {
            return n
        }
        var remain = n
        var times = 1
        var digit = 1

        while (true) {
            val temp = 9 * times * digit
            if (remain <= temp) {
                break
            }
            println("$remain-$temp")

            remain -= temp
            times *= 10
            digit++
        }
        val r = (remain - 1) % digit
        val no = remain / digit

        val number = times + if (r == digit - 1) no - 1 else no
        val c = number.toString().toCharArray()[r]
        return c - '0'
    }

    //    fun findNthDigit(n: Int): Int {
//        if (n <= 9) {
//            return n
//        }
//        var remain = n
//        var times = 1
//        var count = 1
//
//        while (true) {
//            val temp = 9 * times
//            if (remain <= temp) {
//                break
//            }
//            remain -= temp
//            times *= 10
//            count++
//        }
//        val r = (remain - 1) % count
//        val no = remain / count
//
//        val number = times + if (r == count - 1) times + no - 1 else times + no
//        val c = number.toString().toCharArray()[r]
//        return c - '0'
//    }
    fun findNthDigit2(n: Int): Int {
        //记录n是几位数
        var n = n
        var digit = 1
        //记录当前位数区间的起始数字：1,10,100...
        var start: Long = 1
        //记录当前区间之前总共有多少位数字
        var sum: Long = 9
        //将n定位在某个位数的区间中
        while (n > sum) {
            println("$n-$sum")
            n -= sum.toInt()
            start *= 10
            digit++
            //该区间的总共位数
            sum = 9 * start * digit
        }
//        println(n)
//        println(digit)

        //定位n在哪个数字上
        val num = "" + (start + (n - 1) / digit)
        //定位n在数字的哪一位上
        val index = (n - 1) % digit
        return num[index].code - '0'.code
    }
}

fun test(n: Int, digit: Int) {
//    val n = 10000
//    val digit = 34
    val r1 = (n - 1) / digit

    val t2 = n / digit
    val r2 = if (n % digit == 0) t2 - 1 else t2
    if (r1 != r2) {
        println("$n,$digit")
    }
}

fun main() {
//    val c = 500000000
//    val r1 = JZ44.findNthDigit(c)
//    val r2 = JZ44.findNthDigit2(c)
//    println(r1)
//    println(r2)
//    for (n in 500..1000) {
//        for (digit in 5..10) {
//            test(n, digit)
//
//        }
//    }
    println((-1) % 10)
}
