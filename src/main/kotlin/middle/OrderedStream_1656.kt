package middle

class OrderedStream_1656(n: Int) {
    val strings: Array<String?>
    var ptr = 1
    val size: Int

    init {
        strings = Array(n + 1){null}
        size = n
    }


    fun insert(idKey: Int, value: String): List<String> {
        strings[idKey] = value
        return if (strings[ptr] != null) {
            val result = mutableListOf<String>()
            for (i in ptr..size) {
                if (strings[i] == null) {
                    ptr = i
                    return result
                } else {
                    result.add(strings[i]!!)
                }
            }
            return result
        } else {
            listOf()
        }
    }

}