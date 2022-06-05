package middle

object DecodeString_394 {
    fun decodeString(s: String): String {
        val items = s.split(']')
        return items.joinToString(separator = "", transform = this::parserItem)
    }

    fun parserItem(item: String): String {
        if (!item.contains('[')) return item
        val sp = item.split('[')
        val cIndex = sp[0].indexOfAny(charArrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'))

        val s = sp[1]
        val count = sp[0].substring(cIndex, sp[0].length).toInt()
        return sp[0].substring(0, cIndex) + s.repeat(count)
    }
}

fun main() {
    val result = DecodeString_394.decodeString("abc3[cd]xyz")
    println(result)
}