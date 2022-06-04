package easy

object RomanToInt_13 {
    fun romanToInt(s: String): Int {
        val map = hashMapOf(
            'I' to 1,
            'V' to 5,
            'X' to 10,
            'L' to 50,
            'C' to 100,
            'D' to 500,
            'M' to 1000
        )
        var sum = 0
        var i = 0
        while (i < s.length) {
            val c = s[i]
            when (c) {
                'I' -> {
                    if (i == s.length - 1) {
                        sum += 1
                    } else {
                        val next = s[i+1]
                        if (next == 'V') {
                            sum+=4
                            i++
                        } else if (next == 'X') {
                            sum += 9
                            i++
                        } else {
                            sum+=1
                        }
                    }
                }
                'X' -> {
                    if (i == s.length - 1) {
                        sum += 10
                    } else {
                        val next = s[i+1]
                        if (next == 'L') {
                            sum+=40
                            i++
                        } else if (next == 'C') {
                            sum += 90
                            i++
                        } else {
                            sum+=10
                        }
                    }
                }
                'C' -> {
                    if (i == s.length - 1) {
                        sum += 100
                    } else {
                        val next = s[i+1]
                        when (next) {
                            'D' -> {
                                sum+=400
                                i++
                            }
                            'M' -> {
                                sum += 900
                                i++
                            }
                            else -> {
                                sum+=100
                            }
                        }
                    }
                }
                else -> sum += map[c]!!
            }
            i++
        }
        return sum
    }
}