import java.util.concurrent.ThreadLocalRandom


fun main() {
    val i = ThreadLocalRandom.current()
    val a = i.nextInt()
    println(a)

}
