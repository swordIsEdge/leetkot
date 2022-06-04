package jzof

object JZ73 {
    fun ReverseSentence(ReverseSentence: String): String  {
        // write code here
        val res = ReverseSentence.split(" ")
        val reRes = res.reversed()
        return reRes.joinToString(separator = " ")



    }
}