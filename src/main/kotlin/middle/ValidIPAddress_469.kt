package middle

object ValidIPAddress_469 {
    fun validIPAddress(queryIP: String): String {
        return if (queryIP.contains('.')) {
            verifyV4(queryIP)
        } else if (queryIP.contains(':')) {
            verifyV6(queryIP)
        } else {
            "Neither"
        }
    }

    fun verifyV4(queryIP: String): String {
        val items = queryIP.split(".")
        if (items.size != 4) {
            return "Neither"
        }
        for (item in items) {
            if (item.isBlank()||item.length>3) {
                return "Neither"
            }
            for (c in item) {
                if (!c.isDigit()) {
                    return "Neither"
                }
            }
            val num = item.toInt()
            if (num == 0) {
                if (item.length > 1) {
                    return "Neither"
                }
            } else {
                if (num > 255 || num < 0 || item[0] == '0') {
                    return "Neither"
                }
            }
        }
        return "IPv4"
    }

    fun verifyV6(queryIP: String): String {
        val charSet = hashSetOf<Char>('a', 'b', 'c', 'd', 'e', 'f', 'A', 'B', 'C', 'E', 'D', 'F')
        val items = queryIP.split(":")
        if (items.size != 8) {
            return "Neither"
        }
        for (item in items) {
            if (item.isBlank()) {
                return "Neither"
            }
            for (c in item) {
                if (!c.isDigit() && !charSet.contains(c)) {
                    return "Neither"
                }
            }
            if (item.isEmpty() || item.length > 4) {
                return "Neither"
            }
        }
        return "IPv6"
    }
}

fun main() {
    val arg = "1.1.1.1."
//    println(arg.split("."))
    val result = ValidIPAddress_469.validIPAddress(arg)
    println(result)
}