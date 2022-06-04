package jzof

object JZ38 {
    fun Permutation(str: String): Array<String> {
        // write code here
        val flag = BooleanArray(str.length)
        val result = mutableSetOf<String>()
        dfs(0, str.toCharArray(), CharArray(str.length), flag, result)
        return result.toTypedArray()
    }

    fun dfs(i: Int, ca: CharArray, tmp: CharArray, flag: BooleanArray, result: MutableSet<String>) {
        if (i >= ca.size) {
            result.add(String(tmp))
            return
        }
        for ((index, c) in ca.withIndex()) {
            if (flag[index]) {
                continue
            } else {
                flag[index] = true
                val tmpCp = tmp.clone()
                tmpCp[i] = c
                dfs(i+1,ca,tmpCp,flag,result)
                flag[index] = false
            }
        }

    }
}

fun main() {
    val res = JZ38.Permutation("1234")
    for (re in res) {
        println(re)
    }
}