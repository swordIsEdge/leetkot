package easy

object FizzBuzz_412 {
    fun fizzBuzz(n: Int): List<String> {
        val result = (1..n).map { it.toString() }.toMutableList()
        (1..(n/3)).forEach{result[it*3-1] = "Fizz"}
        (1..(n/5)).forEach{result[it*5-1] = "Buzz"}
        (1..(n/15)).forEach{result[it*15-1] = "FizzBuzz"}
        return result
    }
}

fun main() {

}